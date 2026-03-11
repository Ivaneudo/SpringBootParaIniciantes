package com.cursoyt.api_spring_boot_iniciantes.service;

import com.cursoyt.api_spring_boot_iniciantes.model.Usuario;
import com.cursoyt.api_spring_boot_iniciantes.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder;
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = new BCryptPasswordEncoder()  ;
  }

  public Usuario resistrarUsuario(String userName, String password) {
    String senhaCriptografada = passwordEncoder.encode(password);
    Usuario usuario = new Usuario(userName, senhaCriptografada);
    return  usuarioRepository.save(usuario);
  }

  public Usuario buscarPorUserName(String userName) {
    return usuarioRepository.findByUserName(userName);
  }

}
