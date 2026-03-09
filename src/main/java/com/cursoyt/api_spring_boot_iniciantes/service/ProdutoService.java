package com.cursoyt.api_spring_boot_iniciantes.service;

import com.cursoyt.api_spring_boot_iniciantes.exceptions.RecursoNaoEncontradoException;
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

  public Produto buscarPorId(Long id) {
    return produtoRespository.findById(id).orElseThrow(
            () -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado")
    );
  }

  public Produto salvarProduto(Produto produto) {
    return produtoRespository.save(produto);
  }

  public void deletarProduto(Long id) {

    if (!produtoRespository.existsById(id)) {
      throw new RecursoNaoEncontradoException("Produto com ID " + id + "Não encontrado");
    }

    produtoRespository.deleteById(id);
  }

}
