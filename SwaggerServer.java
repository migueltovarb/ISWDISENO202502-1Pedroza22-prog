import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class SwaggerServer {
    static class Dueno {
        long id;
        String nombre;
        String documento;
        String telefono;
        Dueno(long id, String nombre, String documento, String telefono) {
            this.id = id; this.nombre = nombre; this.documento = documento; this.telefono = telefono;
        }
    }
    static class ControlVeterinario {
        long id;
        String fecha;
        String tipo;
        String observaciones;
        ControlVeterinario(long id, String fecha, String tipo, String observaciones) {
            this.id = id; this.fecha = fecha; this.tipo = tipo; this.observaciones = observaciones;
        }
    }
    static class Mascota {
        long id;
        String nombre;
        int edad;
        String especie;
        long duenoId;
        List<ControlVeterinario> controles = new ArrayList<>();
        Mascota(long id, String nombre, int edad, String especie, long duenoId) {
            this.id = id; this.nombre = nombre; this.edad = edad; this.especie = especie; this.duenoId = duenoId;
        }
    }

    private static final Map<Long, Dueno> DUENOS = new LinkedHashMap<>();
    private static final Map<Long, Mascota> MASCOTAS = new LinkedHashMap<>();
    private static final AtomicLong ID_DUENO = new AtomicLong(1);
    private static final AtomicLong ID_MASCOTA = new AtomicLong(1);
    private static final AtomicLong ID_CONTROL = new AtomicLong(1);

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // API endpoints
        server.createContext("/duenos", new OwnersHandler());
        server.createContext("/mascotas", new PetsHandler());
        server.createContext("/controles", new ControlsHandler());
        // Static Swagger files
        server.createContext("/swagger.json", new StaticFileHandler("swagger.json", "application/json"));
        server.createContext("/swagger-ui", new StaticFileHandler("swagger-ui.html", "text/html"));
        server.createContext("/", exchange -> redirect(exchange, "/swagger-ui"));
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado en http://localhost:8080/swagger-ui");
    }

    static class OwnersHandler implements HttpHandler {
        @Override public void handle(HttpExchange ex) throws IOException {
            String method = ex.getRequestMethod();
            if ("GET".equals(method)) {
                StringBuilder sb = new StringBuilder("[");
                boolean first = true;
                for (Dueno d : DUENOS.values()) {
                    if (!first) sb.append(','); first = false;
                    sb.append('{')
                      .append("\"id\":").append(d.id).append(',')
                      .append("\"nombre\":\"").append(escape(d.nombre)).append("\",")
                      .append("\"documento\":\"").append(escape(d.documento)).append("\",")
                      .append("\"telefono\":\"").append(escape(d.telefono)).append("\"}");
                }
                sb.append(']');
                json(ex, 200, sb.toString());
            } else if ("POST".equals(method)) {
                String body = readBody(ex);
                Map<String, String> m = parseJsonObject(body);
                String nombre = m.getOrDefault("nombre", "");
                String documento = m.getOrDefault("documento", "");
                String telefono = m.getOrDefault("telefono", "");
                long id = ID_DUENO.getAndIncrement();
                Dueno d = new Dueno(id, nombre, documento, telefono);
                DUENOS.put(id, d);
                json(ex, 201, "{\"id\":" + id + "}");
            } else {
                json(ex, 405, "{\"error\":\"Método no permitido\"}");
            }
        }
    }

    static class PetsHandler implements HttpHandler {
        @Override public void handle(HttpExchange ex) throws IOException {
            String method = ex.getRequestMethod();
            String path = ex.getRequestURI().getPath();
            if (path.matches("/mascotas/\\d+/historial")) {
                long id = Long.parseLong(path.replaceAll("/mascotas/(\\d+)/historial", "$1"));
                Mascota pet = MASCOTAS.get(id);
                if (pet == null) { json(ex, 404, "{\"error\":\"Mascota no encontrada\"}"); return; }
                StringBuilder sb = new StringBuilder("[");
                boolean first = true;
                for (ControlVeterinario c : pet.controles) {
                    if (!first) sb.append(','); first = false;
                    sb.append('{')
                      .append("\"id\":").append(c.id).append(',')
                      .append("\"fecha\":\"").append(escape(c.fecha)).append("\",")
                      .append("\"tipo\":\"").append(escape(c.tipo)).append("\",")
                      .append("\"observaciones\":\"").append(escape(c.observaciones)).append("\"}");
                }
                sb.append(']');
                json(ex, 200, sb.toString());
                return;
            }

            if ("GET".equals(method)) {
                StringBuilder sb = new StringBuilder("[");
                boolean first = true;
                for (Mascota p : MASCOTAS.values()) {
                    if (!first) sb.append(','); first = false;
                    sb.append('{')
                      .append("\"id\":").append(p.id).append(',')
                      .append("\"nombre\":\"").append(escape(p.nombre)).append("\",")
                      .append("\"edad\":").append(p.edad).append(',')
                      .append("\"especie\":\"").append(escape(p.especie)).append("\",")
                      .append("\"duenoId\":").append(p.duenoId)
                      .append('}');
                }
                sb.append(']');
                json(ex, 200, sb.toString());
            } else if ("POST".equals(method)) {
                String body = readBody(ex);
                Map<String, String> m = parseJsonObject(body);
                String nombre = m.getOrDefault("nombre", "");
                int edad = parseIntSafe(m.get("edad"));
                String especie = m.getOrDefault("especie", "");
                long duenoId = parseLongSafe(m.get("duenoId"));
                if (!DUENOS.containsKey(duenoId)) { json(ex, 400, "{\"error\":\"duenoId inválido\"}"); return; }
                long id = ID_MASCOTA.getAndIncrement();
                Mascota p = new Mascota(id, nombre, edad, especie, duenoId);
                MASCOTAS.put(id, p);
                json(ex, 201, "{\"id\":" + id + "}");
            } else {
                json(ex, 405, "{\"error\":\"Método no permitido\"}");
            }
        }
    }

    static class ControlsHandler implements HttpHandler {
        @Override public void handle(HttpExchange ex) throws IOException {
            String method = ex.getRequestMethod();
            if ("POST".equals(method)) {
                String body = readBody(ex);
                Map<String, String> m = parseJsonObject(body);
                long mascotaId = parseLongSafe(m.get("mascotaId"));
                Mascota pet = MASCOTAS.get(mascotaId);
                if (pet == null) { json(ex, 404, "{\"error\":\"Mascota no encontrada\"}"); return; }
                String fecha = m.getOrDefault("fecha", "");
                String tipo = m.getOrDefault("tipo", "");
                String observaciones = m.getOrDefault("observaciones", "");
                long id = ID_CONTROL.getAndIncrement();
                pet.controles.add(new ControlVeterinario(id, fecha, tipo, observaciones));
                json(ex, 201, "{\"id\":" + id + "}");
            } else {
                json(ex, 405, "{\"error\":\"Método no permitido\"}");
            }
        }
    }

    static class StaticFileHandler implements HttpHandler {
        private final String resource;
        private final String contentType;
        StaticFileHandler(String resource, String contentType) { this.resource = resource; this.contentType = contentType; }
        @Override public void handle(HttpExchange ex) throws IOException {
            try (InputStream is = SwaggerServer.class.getResourceAsStream("/" + resource)) {
                if (is == null) { json(ex, 404, "{\"error\":\"Recurso no encontrado\"}"); return; }
                byte[] data = is.readAllBytes();
                ex.getResponseHeaders().set("Content-Type", contentType + "; charset=utf-8");
                ex.sendResponseHeaders(200, data.length);
                try (OutputStream os = ex.getResponseBody()) { os.write(data); }
            }
        }
    }

    private static void json(HttpExchange ex, int code, String json) throws IOException {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        ex.sendResponseHeaders(code, bytes.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
    }
    private static String readBody(HttpExchange ex) throws IOException {
        try (InputStream is = ex.getRequestBody()) { return new String(is.readAllBytes(), StandardCharsets.UTF_8); }
    }
    // Nota: parser JSON muy simple para objetos plano {"k":"v", "n":123}
    private static Map<String, String> parseJsonObject(String json) {
        Map<String, String> map = new HashMap<>();
        if (json == null) return map;
        String s = json.trim();
        if (s.startsWith("{") && s.endsWith("}")) s = s.substring(1, s.length()-1);
        // split on commas not inside quotes (simple approach)
        int i = 0; boolean inString = false; StringBuilder token = new StringBuilder(); List<String> parts = new ArrayList<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '"') { inString = !inString; token.append(c); }
            else if (c == ',' && !inString) { parts.add(token.toString()); token.setLength(0); }
            else { token.append(c); }
            i++;
        }
        if (token.length() > 0) parts.add(token.toString());
        for (String part : parts) {
            String[] kv = part.split(":", 2);
            if (kv.length == 2) {
                String key = kv[0].trim();
                String val = kv[1].trim();
                if (key.startsWith("\"") && key.endsWith("\"")) key = key.substring(1, key.length()-1);
                if (val.startsWith("\"") && val.endsWith("\"")) val = val.substring(1, val.length()-1);
                map.put(key, val);
            }
        }
        return map;
    }
    private static int parseIntSafe(String s) { try { return Integer.parseInt(s); } catch (Exception e) { return 0; } }
    private static long parseLongSafe(String s) { try { return Long.parseLong(s); } catch (Exception e) { return 0L; } }
    private static String escape(String s) { return s == null ? "" : s.replace("\\", "\\\\").replace("\"", "\\\""); }
    private static void redirect(HttpExchange ex, String to) throws IOException {
        ex.getResponseHeaders().add("Location", to);
        ex.sendResponseHeaders(302, -1);
        ex.close();
    }
}
