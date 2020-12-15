package com.sAdamingo.course.Task26;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class IsPrimeServer {
    private static final String CONTEXT = "/isPrime";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext(CONTEXT, new MyHttpHandler());
        Executor threadPoolExecutor = Executors.newFixedThreadPool(10);
        server.setExecutor(threadPoolExecutor);
        server.start();
    }

    public static class MyHttpHandler implements HttpHandler {

        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                handleGet(httpExchange);
            }
        }

        private void handleResponse(HttpExchange httpExchange, String content, int code) throws IOException {
            try (OutputStream outputStream = httpExchange.getResponseBody()) {
                if (content != null) {
                    httpExchange.getResponseHeaders().add("Content-Type", "application/json");
                }
                httpExchange.sendResponseHeaders(code, content == null ? 0 : content.length());
                if (content != null) {
                    outputStream.write(content.getBytes());
                }
                outputStream.flush();
            }
        }

        private void handleGet(HttpExchange httpExchange) throws IOException {
            String uri = httpExchange.getRequestURI().toString();
            String number = uri.length() > CONTEXT.length() ? uri.substring((CONTEXT + "/").length()) : null;
            String json;
            if (number == null || !isNumeric(number)) {
                handleResponse(httpExchange, null, 404);
            } else {
                json = "{\"number\":" + Integer.parseInt(number) + ",\"isPrime\":" + isPrime(Integer.parseInt(number)) + "}";
                handleResponse(httpExchange, json, 200);
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isPrime(int a) {
        boolean flag = true;
        int temp;
        for (int i = 2; i <= a / 2; i++) {
            temp = a % i;
            if (temp == 0) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}