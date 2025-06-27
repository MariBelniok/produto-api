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

    @GetMapping("/preco")
    public List<Produto> buscarPorPreco(@RequestParam Double valor) {
        return produtoService.findByPreco(valor);
    }
    @GetMapping("/precoMaiorQue")
    public List<Produto> buscarPorPrecoMaiorQue(@RequestParam Double valor) {
        return produtoService.findByPrecoGreaterThan(valor);
    }
    @GetMapping("/precoMenorQue")
    public List<Produto> buscarPorPrecoMenorQue(@RequestParam Double valor) {
        return produtoService.findByPrecoLessThan(valor);
    }
    @GetMapping("/totalPreco")
    public Double buscarTotalPreco() {
        return produtoService.findTotalPreco();
    }

    @GetMapping("/quantidade")
    public List<Produto> buscarPorQuantidade(@RequestParam Double valor) {
        return produtoService.findByQuantidade(valor);
    }
    @GetMapping("/quantidadeMaiorQue")
    public List<Produto> buscarPorQuantidadeMaiorQue(@RequestParam Double valor) {
        return produtoService.findByQuantidadeGreaterThan(valor);
    }
    @GetMapping("/quantidadeMenorQue")
    public List<Produto> buscarPorQuantidadeMenorQue(@RequestParam Double valor) {
        return produtoService.findByQuantidadeLessThan(valor);
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

    // Retorna exclusivamente produtos com status null
    @GetMapping("/buscarPorStatusNulos")
    public List<Produto> buscarPorStatusNulos() {
        return produtoService.findByStatusIsNull();
    }

    // Busca baseada em dois campos (preço e status)
    @GetMapping("/buscarPorPrecoEStatus")
    public List<Produto> buscarPorPrecoEStatus(@RequestParam Double preco,
                                               @RequestParam String status) {
        return produtoService.findByPrecoAndStatus(preco, status);
    }

    // Endpoint para trazer o total de produtos
    @GetMapping("/contarTotalDeProdutos")
    public Long contarTotalDeProdutos() {
        return produtoService.count();
    }
    // Se não passar nada, volta todos produtos com status padrão, neste caso será "Disponível".
    @GetMapping("/buscarPorStatusPadrao")
    public List<Produto> buscarPorStatusPadrao(@RequestParam(defaultValue = "Disponível") String valor) {
        return produtoService.filrarPorStatus(valor);
    }
}
