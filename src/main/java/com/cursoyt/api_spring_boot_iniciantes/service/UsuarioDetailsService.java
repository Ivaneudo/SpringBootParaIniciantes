package com.cursoyt.api_spring_boot_iniciantes.service;

import com.cursoyt.api_spring_boot_iniciantes.model.Usuario;
import com.cursoyt.api_spring_boot_iniciantes.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;
  public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
    try {
      Usuario usuario = usuarioRepository.findByUserName(username);
      return User.builder()
              .username(usuario.getUserName())
              .password(usuario.getPassword())
              .roles("USER")
              .build();
    } catch (UsernameNotFoundException e) {
      throw new UsernameNotFoundException("Usuario não encontrado");
    }
  }

}
