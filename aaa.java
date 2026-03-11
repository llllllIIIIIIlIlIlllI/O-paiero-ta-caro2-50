
public class aaa {

    // ===== PRODUTOS =====
    static String[] nomeProduto    = { "Camiseta", "Calça Jeans", "Tênis", "Boné", "Mochila" };
    static double[] precoProduto   = {   29.90,       99.90,       149.90,  39.90,   79.90   };
    static int[]    estoqueProduto = {    50,           30,           20,     40,      15     };
    static int      totalProdutos  = 5;

    // ===== CLIENTES =====
    static String[] nomeCliente   = new String[50];
    static String[] cpfCliente    = new String[50];
    static int      totalClientes = 0;

    // ===== VENDAS =====
    // Cada venda guarda: índice do cliente + até 10 itens (produto + quantidade)
    static int[]   clienteDaVenda   = new int[50];
    static int[][] indProdutoVenda  = new int[50][10];
    static int[][] qtdProdutoVenda  = new int[50][10];
    static int[]   totalItensVenda  = new int[50];
    static int     totalVendas      = 0;

    // =================================================================

    public static void main(String[] args) {

        // -------- CADASTRO DE CLIENTES --------
        cadastrarCliente("João Silva",    "111.222.333-44");
        cadastrarCliente("Maria Souza",   "555.666.777-88");
        cadastrarCliente("Carlos Mendes", "999.888.777-66");
        cadastrarCliente("Caio", "000.000.000-22");

        // =================================================================
        // VENDA 1 — João compra 2 Camisetas e 1 Calça Jeans
        // =================================================================
        clienteDaVenda[totalVendas]  = 0; // índice de João
        totalItensVenda[totalVendas] = 0;

        // Adicionar Camiseta (índice 0), quantidade 2
        if (estoqueProduto[0] < 2) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[0]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 0;
            qtdProdutoVenda[totalVendas][slot] = 2;
            totalItensVenda[totalVendas]++;
            estoqueProduto[0] -= 2;
        }

        // Adicionar Calça Jeans (índice 1), quantidade 1
        if (estoqueProduto[1] < 1) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[1]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 1;
            qtdProdutoVenda[totalVendas][slot] = 1;
            totalItensVenda[totalVendas]++;
            estoqueProduto[1] -= 1;
        }

        // Fechar venda 1: calcular total e exibir mensagem
        double totalV1 = 0;
        for (int i = 0; i < totalItensVenda[totalVendas]; i++) {
            totalV1 += precoProduto[indProdutoVenda[totalVendas][i]]
                     * qtdProdutoVenda[totalVendas][i];
        }
        System.out.println("Venda #" + (totalVendas + 1) + " finalizada para "
                + nomeCliente[clienteDaVenda[totalVendas]]
                + " — Total: R$ " + String.format("%.2f", totalV1));
        totalVendas++;

        // =================================================================
        // VENDA 2 — Maria compra 1 Tênis e 2 Bonés
        // =================================================================
        clienteDaVenda[totalVendas]  = 1; // índice de Maria
        totalItensVenda[totalVendas] = 0;

        // Adicionar Tênis (índice 2), quantidade 1
        if (estoqueProduto[2] < 1) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[2]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 2;
            qtdProdutoVenda[totalVendas][slot] = 1;
            totalItensVenda[totalVendas]++;
            estoqueProduto[2] -= 1;
        }

        // Adicionar Boné (índice 3), quantidade 2
        if (estoqueProduto[3] < 2) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[3]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 3;
            qtdProdutoVenda[totalVendas][slot] = 2;
            totalItensVenda[totalVendas]++;
            estoqueProduto[3] -= 2;
        }

        // Fechar venda 2: calcular total e exibir mensagem
        double totalV2 = 0;
        for (int i = 0; i < totalItensVenda[totalVendas]; i++) {
            totalV2 += precoProduto[indProdutoVenda[totalVendas][i]]
                     * qtdProdutoVenda[totalVendas][i];
        }
        System.out.println("Venda #" + (totalVendas + 1) + " finalizada para "
                + nomeCliente[clienteDaVenda[totalVendas]]
                + " — Total: R$ " + String.format("%.2f", totalV2));
        totalVendas++;

        // =================================================================
        // VENDA 3 — Carlos compra 1 Mochila e 1 Camiseta
        // =================================================================
        clienteDaVenda[totalVendas]  = 2; // índice de Carlos
        totalItensVenda[totalVendas] = 0;

        // Adicionar Mochila (índice 4), quantidade 1
        if (estoqueProduto[4] < 1) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[4]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 4;
            qtdProdutoVenda[totalVendas][slot] = 1;
            totalItensVenda[totalVendas]++;
            estoqueProduto[4] -= 1;
        }

        // Adicionar Camiseta (índice 0), quantidade 1
        if (estoqueProduto[0] < 1) {
            System.out.println("Estoque insuficiente para: " + nomeProduto[0]);
        } else {
            int slot = totalItensVenda[totalVendas];
            indProdutoVenda[totalVendas][slot] = 0;
            qtdProdutoVenda[totalVendas][slot] = 1;
            totalItensVenda[totalVendas]++;
            estoqueProduto[0] -= 1;
        }

        // Fechar venda 3: calcular total e exibir mensagem
        double totalV3 = 0;
        for (int i = 0; i < totalItensVenda[totalVendas]; i++) {
            totalV3 += precoProduto[indProdutoVenda[totalVendas][i]]
                     * qtdProdutoVenda[totalVendas][i];
        }
        System.out.println("Venda #" + (totalVendas + 1) + " finalizada para "
                + nomeCliente[clienteDaVenda[totalVendas]]
                + " — Total: R$ " + String.format("%.2f", totalV3));
        totalVendas++;



        clienteDaVenda[totalClientes] = 3;
        totalItensVenda[totalVendas] = 0;

        // =================================================================
        // IMPRIMINDO RECIBOS DE TODAS AS VENDAS
        // =================================================================
        for (int v = 0; v < totalVendas; v++) {
            int cli = clienteDaVenda[v];
            System.out.println("\n====== RECIBO VENDA #" + (v + 1) + " ======");
            System.out.println("Cliente : " + nomeCliente[cli] + "  CPF: " + cpfCliente[cli]);
            System.out.println("Itens:");

            double totalRecibo = 0;
            for (int i = 0; i < totalItensVenda[v]; i++) {
                int    prod = indProdutoVenda[v][i];
                int    qtd  = qtdProdutoVenda[v][i];
                double sub  = precoProduto[prod] * qtd;
                totalRecibo += sub;
                System.out.printf("  - %-14s x%d  R$ %.2f%n", nomeProduto[prod], qtd, sub);
            }
            System.out.printf("TOTAL: R$ %.2f%n", totalRecibo);
        }

        // =================================================================
        // RESUMO DE GASTOS POR CLIENTE
        // =================================================================
        System.out.println("\n-------- RESUMO POR CLIENTE --------");
        for (int c = 0; c < totalClientes; c++) {
            double gastoTotal = 0;
            for (int v = 0; v < totalVendas; v++) {
                if (clienteDaVenda[v] == c) {
                    for (int i = 0; i < totalItensVenda[v]; i++) {
                        gastoTotal += precoProduto[indProdutoVenda[v][i]]
                                    * qtdProdutoVenda[v][i];
                    }
                }
            }
            System.out.printf("%-15s | Total gasto: R$ %.2f%n", nomeCliente[c], gastoTotal);
        }

        // =================================================================
        // EXIBINDO ESTOQUE ATUAL
        // =================================================================
        System.out.println("\n-------- ESTOQUE ATUAL --------");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.printf("%-14s | Estoque: %3d un.%n", nomeProduto[i], estoqueProduto[i]);
        }
    }

    // =================================================================

    static void cadastrarCliente(String nome, String cpf) {
        nomeCliente[totalClientes] = nome;
        cpfCliente[totalClientes]  = cpf;
        totalClientes++;
    }
}