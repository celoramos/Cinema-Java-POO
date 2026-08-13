package br.com.cinema.modelos;
public class Serie extends Titulo {
    private String tituloSerie;
    private int temporadas;
    private boolean ativa;
    private int epsTemporada;


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
        return tituloSerie;
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
    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

@Override
public void Serie() {
        System.out.println("Nome da Serie: " + tituloSerie);
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Ativa: " + ativa);
    }

}
