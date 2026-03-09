package com.cursoyt.api_spring_boot_iniciantes.exceptions;

public class RecursoNaoEncontradoException extends  RuntimeException {
  public RecursoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
}
