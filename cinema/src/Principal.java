import br.com.cinema.modelos.Episodio;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.FiltroRecomendacao;
import br.com.cinema.modelos.Serie;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Homem-Aranha 2", 2004);
        meuFilme.setAssinaturaVip(true);
        meuFilme.avaliar(9.5);

        Filme outroFilme = new Filme("Star Wars: O Império Contra-Ataca", 1980);
        outroFilme.setAssinaturaVip(false);
        outroFilme.avaliar(8.5);

        meuFilme.exibirFichaFilme();
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        System.out.println("\nAs avalições do filme: " + meuFilme.getNomeFilme() + " foram: " + meuFilme.mediaAvaliacao);

        Serie nomeSerie = new Serie("The Bear" , 2022);
        nomeSerie.setTemporadas(5);
        nomeSerie.setEpsTemporada(10);
        nomeSerie.setAtiva(true);
        nomeSerie.Serie();

        Episodio primeiro = new Episodio();
        primeiro.setNumero(0);
        primeiro.setSerie(nomeSerie);
        primeiro.setTotalViews(100);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);
        filtro.filtrar(primeiro);

        var filmeMarcelo = new Filme("Alien: O oitavo passageiro", 1979);
        filmeMarcelo.setAssinaturaVip(true);
        filmeMarcelo.avaliar(8.5);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filmeMarcelo);
        listaDeFilmes.add(outroFilme);
        System.out.println("Sua lista possui " + listaDeFilmes.size() + " Filmes");
        for (Filme f : listaDeFilmes) {
            System.out.println(f.getNomeFilme() + " (" + f.getAnoLancamento() + ")");
        }

        // futura atualizacao do sistema
//        Scanner buscaTitulo = new Scanner(System.in);
//        System.out.println("Digite o nome do filme que deseja buscar: ");
//        String busca = buscaTitulo.nextLine();
//        for (Filme f : listaDeFilmes)
//            if (f.getNomeFilme().equalsIgnoreCase(busca)) {
//                System.out.println("Filme encontrado: " + f.getNomeFilme());
//            }

        filtro.filtrar(filmeMarcelo);
        Object objeto = filmeMarcelo;
    }
}
