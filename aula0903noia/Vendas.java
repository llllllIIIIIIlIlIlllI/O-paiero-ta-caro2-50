package aula0903noia;

import java.util.ArrayList;

class ItemVenda {
    Produtos produto;
    int qtdd;

    ItemVenda(Produtos produto, int qtdd) {
        this.produto = produto;
        this.qtdd = qtdd;
    }

    double calcularSubtotal() {
        return produto.preco * qtdd;
    }
}

public class Vendas {
    Cliente cliente;

    ArrayList<ItemVenda> vendas = new ArrayList<>();

    Vendas(Cliente cliente) {
        this.cliente = cliente;
    }

    void realizarVenda(Produtos produtos, int qtdd) {
        if (produtos.estoquePdt >= qtdd) {
            ItemVenda item = new ItemVenda(produtos, qtdd);
            vendas.add(item);
            produtos.estoquePdt -= qtdd;
            System.out.println("Venda realizada " + qtdd +" x " + produtos.nome);
        } else {
            System.out.println("Não há estoque disponível.");
        }
    }

    void exibirDados() {
    }
}
