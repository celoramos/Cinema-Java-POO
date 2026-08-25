package br.com.cinema.modelos.principal;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.Serie;
import br.com.cinema.modelos.Titulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

//lista dos filmes
public class ListaPrincipal {
    static void main(String[] args) {
        Filme filme1 = new Filme("Homem-Aranha 2", 2004);
        filme1.avaliar(9.5);
        Filme Filme2 = new Filme("Star Wars: O Império Contra-Ataca", 1980);
        Filme2.avaliar(8.5);
        var Filme3 = new Filme("Alien: O oitavo passageiro", 1979);
        Filme3.avaliar(9.0);
        Serie Serie1 = new Serie("The Bear" , 2022);
        Serie1.avaliar(8.0);


// lista dos filmes e séries
        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(Filme3);
        lista.add(Filme2);
        lista.add(Serie1);

        Collections.sort(lista);
        System.out.println("\nTítulos em ordem numérica:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getNomeFilme() + " (" + lista.get(i).getAnoLancamento() + ")" +
                    "\nClassificação: " + (lista.get(i) instanceof Filme filme ? filme.getClassificacao() : "N/A"));
        }

// lista de atores
       ArrayList<String> buscarAtor = new ArrayList<>();
        buscarAtor.add("Tobey Maguire");
        buscarAtor.add("Mark Hamill");
        buscarAtor.add("Sigourney Weaver");
        buscarAtor.add("Jeremy Allen White");

        Collections.sort(buscarAtor);
        System.out.println("\nOrdenando a lista de atores em ordem alfabética: ");
        for (int i = 0; i < buscarAtor.size(); i++) {
            System.out.println((i + 1) + ". " + buscarAtor.get(i));
        }
    }
}
