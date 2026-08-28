package br.com.cinema.modelos;

public record TituloOMDB(String title, String year, String runtime) {
  public TituloOMDB(TituloOMDB meuTituloOMDB) {
    this(meuTituloOMDB.title(), meuTituloOMDB.year(), meuTituloOMDB.runtime());
  }
}
