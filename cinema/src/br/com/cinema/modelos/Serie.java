package br.com.cinema.modelos;
public class Serie extends Titulo {
    private String nomeSerie;
    private int temporadas;
    private boolean ativa;
    private int epsTemporada;

    public Serie(String nomeSerie, int anoLancamento) {
        super(nomeSerie, anoLancamento);
        this.nomeSerie = nomeSerie;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public int getTemporadas() {
        return temporadas;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public int getEpsTemporada() {
        return epsTemporada;
    }


    public String getTituloSerie() {
        return nomeSerie;
    }


    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public void setEpsTemporada(int epsTemporada) {
        this.epsTemporada = epsTemporada;
    }
    public void setTituloSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    @Override
    public void Serie() {
        System.out.println("\nNome da Serie: " + getNomeFilme());
        System.out.println("Temporadas: " + temporadas);
        if (ativa == true) {
            System.out.println("Ativa: Sim");
        } else {
            System.out.println("Ativa: Não");
        }
        System.out.println();
    }
}
