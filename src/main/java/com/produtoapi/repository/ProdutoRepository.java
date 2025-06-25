package com.produtoapi.repository;

import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findByStatus(String status);

    public List<Produto> findByNome(String nome);
    public List<Produto> findByNomeContaining(String nome);
    public List<Produto> findByNomeAndStatus(String nome, String status);
    public List<Produto> findByNomeStartingWith(String prefix);
    public List<Produto> findByNomeEndingWith(String suffix);
}
