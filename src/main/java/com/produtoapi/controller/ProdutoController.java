package com.produtoapi.controller;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/nome")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return produtoService.findByNome(nome);
    }

    @GetMapping("/nomeEStatus")
    public List<Produto> buscarPorNomeEStatus(@RequestParam String nome, String status) {
        return produtoService.findByNomeAndStatus(nome, status);
    }

    @GetMapping("/nomeContendo")
    public List<Produto> buscarPorNomeContendo(@RequestParam String nome) {
        return produtoService.findByNomeContaining(nome);
    }

    @GetMapping("/nomeTerminandoCom")
    public List<Produto> buscarPorNomeTerminandoCom(@RequestParam String suffix) {
        return produtoService.findByNomeEndingWith(suffix);
    }

    @GetMapping("/nomeComecandoCom")
    public List<Produto> buscarPorNomeComecandoCom(@RequestParam String prefix) {
        return produtoService.findByNomeStartingWith(prefix);
    }

    @GetMapping("/status")
    public List<Produto> filtrarPorStatus(@RequestParam String status) {
        return produtoService.filrarPorStatus(status);
    }

    @GetMapping
    public Page<Produto> listarTodos(@PageableDefault(page = 0, size = 200) Pageable pageable) {
        return produtoService.listarTodos(pageable);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PostMapping("/salvarLista")
    public List<Produto> salvarLista(@RequestBody List<Produto> produtos) {
        return produtoService.salvarLista(produtos);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Long id) {
        return produtoService.obter(id);
    }
}
