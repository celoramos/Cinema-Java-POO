package br.com.cinema.modelos.principal;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.Serie;
import br.com.cinema.modelos.Titulo;

import java.util.ArrayList;

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

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(Filme3);
        lista.add(Filme2);
        lista.add(Serie1);

        for (Titulo item : lista) {
            System.out.println(item.getNomeFilme());
            if (item instanceof Filme filme) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }
    }
}
