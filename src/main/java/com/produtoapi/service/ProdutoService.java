package com.produtoapi.service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findByNome(String nome){
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> findByNomeContaining(String nome){
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> findByNomeAndStatus(String nome, String status){
        return produtoRepository.findByNomeAndStatus(nome, status);
    }

    public List<Produto> findByNomeStartingWith(String prefix){
        return produtoRepository.findByNomeStartingWith(prefix);
    }

    public List<Produto> findByNomeEndingWith(String suffix) {
        return produtoRepository.findByNomeEndingWith(suffix);
    }

    public List<Produto> findByPreco(Double preco) {
        return produtoRepository.findByPreco(preco);
    }
    public List<Produto> findByPrecoGreaterThan(Double preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }
    public List<Produto> findByPrecoLessThan(Double preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }
    public Double findTotalPreco() {
        return produtoRepository.findTotalPreco();
    }

    public List<Produto> findByQuantidade(Double quantidade){
        return produtoRepository.findByQuantidade(quantidade);
    }
    public List<Produto> findByQuantidadeGreaterThan(Double quantidade){
        return produtoRepository.findByQuantidadeGreaterThan(quantidade);
    }
    public List<Produto> findByQuantidadeLessThan(Double quantidade){
        return produtoRepository.findByQuantidadeLessThan(quantidade);
    }

    public List<Produto> filrarPorStatus(String status) {
        return produtoRepository.findByStatus(status);
    }

    public List<Produto> findByStatusIsNull() {
        return produtoRepository.findByStatusIsNull();
    }
    public List<Produto> findByPrecoAndStatus(Double preco, String status) {
        return produtoRepository.findByPrecoAndStatus(preco, status);
    }

    // Método para trazer o número total de produtos
    public Long count() {
        return produtoRepository.count();
    }

    public Optional<Produto> obter(Long id) {
        return produtoRepository.findById(id);
    }

    public Page<Produto> listarTodos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> salvarLista(List<Produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }

    public void deletar(long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado.");
        }
    }
}
