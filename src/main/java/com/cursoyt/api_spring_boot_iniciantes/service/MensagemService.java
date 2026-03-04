package com.cursoyt.api_spring_boot_iniciantes.service;

import com.cursoyt.api_spring_boot_iniciantes.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

  private final MensagemRepository mensagemRepository;

  public MensagemService(MensagemRepository mensagemRepository) {
    this.mensagemRepository = mensagemRepository;
  }

  public Object ObterMensagem() {
    return mensagemRepository.ObterMensagem();
  }

}
