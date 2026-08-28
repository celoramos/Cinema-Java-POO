package br.com.cinema.modelos.Exception;

public class ErroConversaoDeAnoException extends RuntimeException {
  private String mensagem;

  public ErroConversaoDeAnoException(String mensagem) {
    this.mensagem = mensagem;
  }

  @Override
  public String getMessage() {
    return mensagem;
  }
}
