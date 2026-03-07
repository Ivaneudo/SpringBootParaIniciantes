package com.cursoyt.api_spring_boot_iniciantes.controller;

import com.cursoyt.api_spring_boot_iniciantes.model.Produto;
import com.cursoyt.api_spring_boot_iniciantes.service.ProdutoService;
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
  public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id) {
    return produtoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Produto criarProduto(@RequestBody Produto produto) {
    return produtoService.salvarProduto(produto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProduto(@PathVariable("id") Produto produto) {
    produtoService.deletarProduto(produto.getId());
    return  ResponseEntity.ok().build();
  }

}
