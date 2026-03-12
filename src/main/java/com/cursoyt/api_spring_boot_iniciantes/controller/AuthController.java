package com.cursoyt.api_spring_boot_iniciantes.controller;

import com.cursoyt.api_spring_boot_iniciantes.model.Usuario;
import com.cursoyt.api_spring_boot_iniciantes.security.JwtUtil;
import com.cursoyt.api_spring_boot_iniciantes.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UsuarioService usuarioService;

  public AuthController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }


  @PostMapping("/resister")
  public ResponseEntity<?> resister(@RequestBody Map<String, String> request) {
    Usuario usuario = usuarioService.resistrarUsuario(request.get("username"), "password");
    return ResponseEntity.ok(usuario);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    Optional<Usuario> usuario = usuarioService.buscarPorUserName(request.get("username"));

    if(usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
      String token = JwtUtil.generateToken(usuario.get().getUserName());
      return ResponseEntity.ok(Map.of("token", token));
    }

    return ResponseEntity.status(401).body("Creadenciais invalidas");
  }
}
