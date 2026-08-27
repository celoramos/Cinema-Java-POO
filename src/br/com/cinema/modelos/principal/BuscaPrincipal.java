package br.com.cinema.modelos.principal;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.Titulo;
import br.com.cinema.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaPrincipal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de um filme: ");
        var buscarFilme = scanner.nextLine();

        String urlBusca = "http://www.omdbapi.com/?t=" + buscarFilme + "&apikey=bd22c3ca";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlBusca))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);


            int ano = Integer.parseInt(meuTituloOMDB.year());
            Titulo meuTitulo = new Filme(meuTituloOMDB.title(), ano);

            String runtime = meuTituloOMDB.runtime();
            int minutos = Integer.parseInt(runtime.replaceAll("[^0-9]", "").trim());
            int horas = minutos / 60;

            System.out.println("Nome do filme: " + meuTitulo.getNomeFilme());
            System.out.println("Ano de Lançamento: " + meuTitulo.getAnoLancamento());
            if (horas > 1) {
                System.out.println("Duração: " + horas + " hrs e " + (minutos % 60) + " minutos");
            } if (horas == 1) {
                System.out.println("Duração: " + horas + " hr e " + (minutos % 60) + " minutos");
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento: " + e.getMessage());
        }
        System.out.println("O programa será finalizado");
    }
}