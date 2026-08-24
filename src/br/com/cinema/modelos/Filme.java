package br.com.cinema.modelos;
public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void Serie() {
    }

    @Override
    public int getClassificacao() {
        return (int) mediaAvaliacao / 2;
    }

    @Override
    public String toString() {
        return "\nFilme: " +this.getNomeFilme() + " (" +this.getAnoLancamento() + ")";
    }


}
