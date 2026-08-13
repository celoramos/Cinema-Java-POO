package br.com.cinema.modelos;
public class FiltroRecomendacao {
    private String Recomendacao;

    public void filtrar(Classificavel classificavel) {
        int classificacao = classificavel.getClassificacao();

        if (classificacao >= 4) {
            System.out.println("Está entre os preferidos no momento");
        } else if (classificacao >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
