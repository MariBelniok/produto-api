package com.produtoapi.model;

import java.util.List;

public class PaginatedProduto {
    private List<Produto> content;

    public List<Produto> getContent() {
        return content;
    }

    public void setContent(List<Produto> content) {
        this.content = content;
    }
}
