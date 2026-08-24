package br.com.cinema.modelos.principal;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class BuscaPrincipal {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create("http://www.omdbapi.com/?i=tt3896198&apikey=bd22c3ca"))
                .build();
    }

}
