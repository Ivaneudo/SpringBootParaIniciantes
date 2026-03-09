package com.cursoyt.api_spring_boot_iniciantes.controller;

import com.cursoyt.api_spring_boot_iniciantes.exceptions.RecursoNaoEncontradoException;
import com.cursoyt.api_spring_boot_iniciantes.model.Produto;
import com.cursoyt.api_spring_boot_iniciantes.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @GetMapping
  public List<Produto> listarProduto() {
    return produtoService.listarProdutos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscarProducePorId(@PathVariable("id") Long id) {
    try {
      Produto produto = produtoService.buscarPorId(id);
      return ResponseEntity.ok(produto);
    }catch (RecursoNaoEncontradoException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public Produto criarProduto(@RequestBody Produto produto) {
    return produtoService.salvarProduto(produto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletableProduto(@PathVariable("id") Produto produto) {
    produtoService.deletarProduto(produto.getId());
    return  ResponseEntity.ok().build();
  }

}
