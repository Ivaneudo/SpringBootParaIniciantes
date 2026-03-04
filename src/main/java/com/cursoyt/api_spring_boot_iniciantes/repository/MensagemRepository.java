package com.cursoyt.api_spring_boot_iniciantes.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

  public String ObterMensagem() {
    return "Olá do repositorio.";
  }

}
