package com.cursoyt.api_spring_boot_iniciantes.repository;

import com.cursoyt.api_spring_boot_iniciantes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findByUserName(String email);


}
