package com.devops;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);

        server.createContext("/", (HttpExchange exchange) -> {

            String response = """
                    <html>
                    <body style='font-family:Arial;text-align:center;padding-top:100px'>
                    <h1>Java DevOps CI/CD Application</h1>
                    <h2>Successfully Deployed using Jenkins + Docker + ArgoCD + Kubernetes</h2>
                    <h3>POC-3 GitOps Pipeline Working Successfully</h3>
                    </body>
                    </html>
                    """;

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        server.start();

        System.out.println("Application Started on Port 8082");
    }
}
