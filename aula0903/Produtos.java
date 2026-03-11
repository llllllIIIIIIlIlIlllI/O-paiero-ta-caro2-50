class Produto {
    String nome;
    double preco;
    int estoque;

    Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    boolean temEstoque(int quantidade) {
        return this.estoque >= quantidade;
    }

    void reduzirEstoque(int quantidade) {
        this.estoque -= quantidade;
    }
}