package com.cursoyt.api_spring_boot_iniciantes.controller;

import com.cursoyt.api_spring_boot_iniciantes.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

  @Autowired
  private MensagemService mensagemService;

  @GetMapping("/msg")
  public Object ObterMensagem() {
    return mensagemService.ObterMensagem();
  }

}
