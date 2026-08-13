import br.com.cinema.modelos.Episodio;
import br.com.cinema.modelos.Filme;
import br.com.cinema.modelos.FiltroRecomendacao;
import br.com.cinema.modelos.Serie;
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNomeFilme("Homem-Aranha 2");
        meuFilme.setAnoLancamento(2004);
        meuFilme.setAssinaturaVip(true);

        meuFilme.exibirFichaFilme();
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        meuFilme.avaliar(9);
        System.out.println(meuFilme.mediaAvaliacao);

        Serie nomeSerie = new Serie();
        nomeSerie.setNomeFilme("House of the Dragons");
        nomeSerie.setTemporadas(3);
        nomeSerie.setAnoLancamento(2022);
        nomeSerie.setAtiva(true);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);

        Episodio primeiro = new Episodio();
        primeiro.setNumero(1);
        primeiro.setSerie(nomeSerie);
        primeiro.setTotalViews(100);

        filtro.filtrar(primeiro);
    }
}
