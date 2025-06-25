package com.produtoapi.runner;

import com.produtoapi.model.PaginatedProduto;
import com.produtoapi.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StartupRestClientRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RestClient sendo executado");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/produto";

        PaginatedProduto paginatedProduto = restTemplate.getForObject(url, PaginatedProduto.class);
        List<Produto> produtos = paginatedProduto.getContent();

        produtos.forEach(produto -> System.out.println("ID: " + produto.getId() + " " + produto.getNome() + " R$: " + produto.getPreco()));
    }
}
