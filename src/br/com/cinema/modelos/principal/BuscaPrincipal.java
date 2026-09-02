package br.com.cinema.modelos.principal;

import br.com.cinema.modelos.Exception.ErroConversaoDeAnoException;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.Titulo;
import br.com.cinema.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaPrincipal {
  public static void main(String[] args) throws IOException, InterruptedException {
    Scanner scanner = new Scanner(System.in);
    String find = "";
    List<Titulo> titulos = new ArrayList<>();
    var gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    while (!find.equalsIgnoreCase("sair")) {
      System.out.print("Digite o nome de um filme (ou 'sair' para encerrar): ");
      var buscarFilme = scanner.nextLine();
      find = buscarFilme;
      if (find.equals("sair")) {
        break;
      }

      String urlBusca =
              "http://www.omdbapi.com/?t=" + buscarFilme.replace(" ", "+") + "&apikey=bd22c3ca";
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlBusca)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);

        String anoTexto = meuTituloOMDB.year();
        if (anoTexto == null || anoTexto.length() > 4) {
          throw new ErroConversaoDeAnoException(
                  "Não foi possível converter o ano de lançamento do filme: " + meuTituloOMDB.title());
        }

        int ano = Integer.parseInt(anoTexto);
        var meuTitulo = new Filme(meuTituloOMDB.title(), ano);

        String runtime = meuTituloOMDB.runtime();
        int minutos = Integer.parseInt(runtime.replaceAll("[^0-9]", "").trim());
        int horas = minutos / 60;

        System.out.println("Nome do filme: " + meuTitulo.getNomeFilme());
        System.out.println("Ano de Lançamento: " + meuTitulo.getAnoLancamento());
        if (horas > 1) {
          System.out.println("Duração: " + horas + " hrs e " + (minutos % 60) + " minutos");
        }
        if (horas == 1) {
          System.out.println("Duração: " + horas + " hr e " + (minutos % 60) + " minutos");
        }


        titulos.add(meuTitulo);
      } catch (NumberFormatException e) {
        System.out.println("Erro: " + e.getMessage());
      } catch (IllegalArgumentException e) {
        System.out.println("Erro de argumento: " + e.getMessage());
      } catch (ErroConversaoDeAnoException e) {
        System.out.println("Erro de conversão de ano: " + e.getMessage());
      }


    }
    System.out.println("Filmes encontrados:");
    for (int Titulo = 0; Titulo < titulos.size(); Titulo++) {
      System.out.println(
              (Titulo + 1)
                      + ". "
                      + titulos.get(Titulo).getNomeFilme()
                      + " ("
                      + titulos.get(Titulo).getAnoLancamento()
                      + ")");

    }
    var writer = new FileWriter("filmes.json");
    writer.write(gson.toJson(titulos));
    writer.close();
  }
}
