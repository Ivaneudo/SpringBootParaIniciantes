package com.cursoyt.api_spring_boot_iniciantes.service;

import com.cursoyt.api_spring_boot_iniciantes.model.Produto;
import com.cursoyt.api_spring_boot_iniciantes.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRespository;

  public ProdutoService(ProdutoRepository produtoRespository) {
    this.produtoRespository = produtoRespository;
  }

  public List<Produto> listarProdutos() {
    return produtoRespository.findAll();
  }

  public Optional<Produto> buscarPorId(Long id) {
    return produtoRespository.findById(id);
  }

  public Produto salvarProduto(Produto produto) {
    return produtoRespository.save(produto);
  }

  public void deletarProduto(Long id) {
    produtoRespository.deleteById(id);
  }

}
