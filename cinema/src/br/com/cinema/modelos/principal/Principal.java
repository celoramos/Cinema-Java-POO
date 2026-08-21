package br.com.cinema.modelos.principal;
import br.com.cinema.modelos.Episodio;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.FiltroRecomendacao;
import br.com.cinema.modelos.Serie;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        // primeiro filme
        Filme Filme1 = new Filme("Homem-Aranha 2", 2004);
        Filme1.setAssinaturaVip(true);
        Filme1.avaliar(9.5);

        // ficha do filme 1 (vou tirar depois pra aparecer so a classificacao)
        Filme1.exibirFichaFilme();
        Filme1.avaliar(9);
        Filme1.avaliar(9);
        Filme1.avaliar(9);
        Filme1.avaliar(9);

        // filme 2
        Filme Filme2 = new Filme("Star Wars: O Império Contra-Ataca", 1980);
        Filme2.setAssinaturaVip(false);
        Filme2.avaliar(8.5);
        System.out.println("\nAs avalições do filme: " + Filme1.getNomeFilme() + " foram: " + Filme1.mediaAvaliacao);

        // filme 3
        var Filme3 = new Filme("Alien: O oitavo passageiro", 1979);
        Filme3.setAssinaturaVip(true);
        Filme3.avaliar(8.5);

        // the bear
        Serie Serie1 = new Serie("The Bear" , 2022);
        Serie1.setTemporadas(5);
        Serie1.setEpsTemporada(10);
        Serie1.setAtiva(true);
        Serie1.Serie();

        Episodio primeiro = new Episodio();
        primeiro.setNumero(0);
        primeiro.setSerie(Serie1);
        primeiro.setTotalViews(100);

// filtro
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(Filme1);
        filtro.filtrar(primeiro);


        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(Filme1);
        listaDeFilmes.add(Filme3);
        listaDeFilmes.add(Filme2);
        System.out.println("Sua lista possui " + listaDeFilmes.size() + " Filmes");
        for (Filme f : listaDeFilmes) {
            System.out.println(f.getNomeFilme() + " (" + f.getAnoLancamento() + ")");
        }


        Scanner buscaTitulo = new Scanner(System.in);
        boolean encontrado = false;
        do {
            System.out.println("Digite o nome do filme que deseja buscar: ");
            String busca = buscaTitulo.nextLine();
            encontrado = false;

            for (Filme f : listaDeFilmes) {
                String nomeNormalizado = f.getNomeFilme()
                        .toLowerCase()
                        .replace("-", "")
                        .replace(" ", "");

                String buscaNormalizada = busca
                        .toLowerCase()
                        .replace("-", "")
                        .replace(" ", "");

                if (nomeNormalizado.equals(buscaNormalizada)) {
                    System.out.println("Filme encontrado: "
                            + f.getNomeFilme()
                            + " (" + f.getAnoLancamento() + ")"
                            + " com média de avaliação: " + f.mediaAvaliacao);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Filme não encontrado. Digite novamente.");
            }

        } while (!encontrado);
        filtro.filtrar(Filme3);
        Object objeto = Filme3;
    }

    private static String normalizar(String busca) {
        return busca.toLowerCase().replace("-", "").replace(" ", "");
    }
}
