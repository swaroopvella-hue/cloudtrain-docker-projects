import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String portEnv = System.getenv("PORT");
        if (portEnv != null) {
            try {
                port = Integer.parseInt(portEnv);
            } catch (NumberFormatException e) {
                System.out.println("Invalid PORT environment variable, defaulting to 8080");
            }
        }
        
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new HtmlHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Frontend Java server started on port " + port);
    }

    static class HtmlHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Path filePath = Paths.get("index.html");
            if (Files.exists(filePath)) {
                byte[] response = Files.readAllBytes(filePath);
                t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                t.sendResponseHeaders(200, response.length);
                OutputStream os = t.getResponseBody();
                os.write(response);
                os.close();
            } else {
                String response = "<h1>404 Not Found</h1><p>index.html was not found on the server.</p>";
                t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                t.sendResponseHeaders(404, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
