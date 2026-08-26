package br.com.cinema.modelos.principal;
import br.com.cinema.modelos.Titulo;
import br.com.cinema.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Scanner;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaPrincipal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de um filme: ");
        var buscarFilme = scanner.nextLine();

        String urlBusca = "http://www.omdbapi.com/?t=" + buscarFilme + "&apikey=bd22c3ca";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBusca))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
        System.out.println("Nome do filme: " + meuTituloOMDB.title() + "\nAno de Lançamento: " + meuTituloOMDB.year() + "\nDuração: " + meuTituloOMDB.runtime());
    }
}

