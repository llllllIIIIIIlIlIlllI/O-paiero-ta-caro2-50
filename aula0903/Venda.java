import java.util.ArrayList;
import java.util.List;

class ItemVenda {
    Produto produto;
    int quantidade;

    ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    double getSubtotal() {
        return produto.preco * quantidade;
    }
}

class Venda {
    Cliente cliente;
    List<ItemVenda> itens = new ArrayList<>();

    Venda(Cliente cliente) {
        this.cliente = cliente;
    }

    void adicionarItem(Produto p, int qtd) {
        if (p.temEstoque(qtd)) {
            itens.add(new ItemVenda(p, qtd));
            p.reduzirEstoque(qtd);
        } else {
            System.out.println("Estoque insuficiente para: " + p.nome);
        }
    }

    double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    void imprimirRecibo(int numeroVenda) {
        System.out.println("\n====== RECIBO VENDA #" + numeroVenda + " ======");
        System.out.println("Cliente: " + cliente.nomeCliente + " CPF: " + cliente.cpfCliente);
        System.out.println("Itens:");
        for (ItemVenda item : itens) {
            System.out.printf(" - %-14s x%d R$ %.2f%n", item.produto.nome, item.quantidade, item.getSubtotal());
        }
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }
}