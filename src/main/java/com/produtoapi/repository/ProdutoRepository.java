package com.produtoapi.repository;

import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findByStatus(String status);
    public List<Produto> findByStatusIsNull();
    public List<Produto> findByPrecoAndStatus(Double preco, String status);

    public List<Produto> findByNome(String nome);
    public List<Produto> findByNomeContaining(String nome);
    public List<Produto> findByNomeAndStatus(String nome, String status);
    public List<Produto> findByNomeStartingWith(String prefix);
    public List<Produto> findByNomeEndingWith(String suffix);

    public List<Produto> findByPreco(Double preco);
    public List<Produto> findByPrecoGreaterThan(Double preco);
    public List<Produto> findByPrecoLessThan(Double preco);

    public List<Produto> findByQuantidade(Double quantidade);
    public List<Produto> findByQuantidadeGreaterThan(Double quantidade);
    public List<Produto> findByQuantidadeLessThan(Double quantidade);

    @Query("SELECT SUM(p.preco) FROM Produto p")
    Double findTotalPreco();
}
