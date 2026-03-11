import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicialização de Produtos
        Produto p1 = new Produto("Camiseta", 29.90, 50);
        Produto p2 = new Produto("Calça Jeans", 99.90, 30);
        Produto p3 = new Produto("Tênis", 149.90, 20);
        Produto p4 = new Produto("Boné", 39.90, 40);
        Produto p5 = new Produto("Mochila", 79.90, 15);

        // Cadastro de Clientes 
        Cliente joao = new Cliente("João Silva", "111.222.333-44");
        Cliente maria = new Cliente("Maria Souza", "555.666.777-88");
        Cliente carlos = new Cliente("Carlos Mendes", "999.888.777-66");
        Cliente caio = new Cliente("Caio Paiva", "000.000.000-42222");

        List<Venda> vendas = new ArrayList<>();
        
        // VENDA 1
        Venda v1 = new Venda(joao);
        v1.adicionarItem(p1, 2);
        v1.adicionarItem(p2, 1);
        vendas.add(v1);
        System.out.println("Venda #1 finalizada para " + joao.nomeCliente + " Total: R$" + String.format("%.2f", v1.calcularTotal()));

        // VENDA 2
        Venda v2 = new Venda(maria);
        v2.adicionarItem(p3, 1);
        v2.adicionarItem(p4, 2);
        vendas.add(v2);
        System.out.println("Venda #2 finalizada para " + maria.nomeCliente + " Total: R$" + String.format("%.2f", v2.calcularTotal()));

        // VENDA 3
        Venda v3 = new Venda(carlos);
        v3.adicionarItem(p5, 1);
        v3.adicionarItem(p1, 1);
        vendas.add(v3);
        System.out.println("Venda #3 finalizada para " + carlos.nomeCliente + " Total: R$" + String.format("%.2f", v3.calcularTotal()));        

        // IMPRIMINDO RECIBOS
        int numeroRecibo = 1;

        for (Venda vendaa : vendas) {
            vendaa.imprimirRecibo(numeroRecibo++);
        }

        // ESTOQUE ATUAL
        System.out.println("\n-- ESTOQUE ATUAL --");
        Produto[] produtos = {p1, p2, p3, p4, p5};
        for (Produto p : produtos) {
            System.out.printf("%-14s | Estoque: %3d un.%n", p.nome, p.estoque);
        }
    }
}