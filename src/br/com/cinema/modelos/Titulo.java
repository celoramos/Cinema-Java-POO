package br.com.cinema.modelos;
import com.google.gson.annotations.SerializedName;

public abstract class Titulo  implements Comparable<Titulo> {
        @SerializedName("Titulo")
    private String nomeFilme;
        @SerializedName("AnoLancamento")
    private int anoLancamento;
    private boolean assinaturaVip;
    private int totalAvaliacoes;
    private double somaAvaliacoes;
    public double mediaAvaliacao;

    public Titulo(String nomeFilme, int anoLancamento) {
        this.nomeFilme = nomeFilme;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOMDB meuTituloOMDB) {
        this.nomeFilme = meuTituloOMDB.title();
        this.anoLancamento = Integer.parseInt(meuTituloOMDB.year());

    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    public void setAssinaturaVip(boolean assinaturaVip) {
        this.assinaturaVip = assinaturaVip;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public String getNomeFilme() {
        return nomeFilme;
    }
    public boolean isAssinaturaVip() {
        return assinaturaVip;
    }


    public void exibirFichaFilme() {}

    public void avaliar(double avaliacao) {
        totalAvaliacoes++;
        somaAvaliacoes += avaliacao;
        mediaAvaliacao = somaAvaliacoes / totalAvaliacoes;
    }

    @Override
        public int compareTo(Titulo outroTitulo) {
            return this.nomeFilme.compareTo(outroTitulo.getNomeFilme());
        }

    @Override
    public String toString() {
        return "Título: " + this.getNomeFilme()
                + " (" + this.getAnoLancamento()
                + ")" + " - Média de Avaliações: "
                + this.mediaAvaliacao
                + " - Total de Avaliações: "
                + this.totalAvaliacoes;
    }

    public abstract void Serie();
    }

