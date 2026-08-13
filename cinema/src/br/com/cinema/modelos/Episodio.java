package br.com.cinema.modelos;
public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalViews;


    public String getNome() {
        return nome;
    }
    public int getTotalViews() {
        return totalViews;
    }
    public int getNumero() {
        return numero;
    }
    public Serie getSerie() {
        return serie;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    private static final int maxViews = 1000;

    @Override
    public int getClassificacao() {
        if (this.totalViews <= 0) {
            return 0;
        }
        int rating = (int) Math.round((double) this.totalViews / maxViews * 10);
        return Math.max(0, Math.min(10, rating));
    }
}
