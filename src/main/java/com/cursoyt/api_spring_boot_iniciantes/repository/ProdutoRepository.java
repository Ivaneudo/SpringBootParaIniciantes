package com.cursoyt.api_spring_boot_iniciantes.repository;

import com.cursoyt.api_spring_boot_iniciantes.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
