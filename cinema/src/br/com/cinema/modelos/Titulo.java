package br.com.cinema.modelos;
    public abstract class Titulo  implements Comparable<Titulo> {
    private String nomeFilme;
    private int anoLancamento;
    private boolean assinaturaVip;
    private int totalAvaliacoes;
    private double somaAvaliacoes;
    public double mediaAvaliacao;

    public Titulo(String nomeFilme, int anoLancamento) {
        this.nomeFilme = nomeFilme;
        this.anoLancamento = anoLancamento;
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


    public void exibirFichaFilme() {
//        System.out.println("Nome do br.com.cinema.modelos.Filme: " + nomeFilme);
//        System.out.println("Ano do Lançamento: " + anoLancamento);
    }

    public void avaliar(double avaliacao) {
        totalAvaliacoes++;
        somaAvaliacoes += avaliacao;
        mediaAvaliacao = somaAvaliacoes / totalAvaliacoes;
    }
    @Override
        public int compareTo(Titulo outroTitulo) {
            return this.nomeFilme.compareTo(outroTitulo.getNomeFilme());
        }

        public abstract void Serie();
    }

