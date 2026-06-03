package SistemaVendas;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Sistema de Vendas e Controle de Estoque ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Vendas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> gerenciarProdutos(scanner);
                case 2 -> gerenciarClientes(scanner);
                case 3 -> gerenciarVendas(scanner);
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Encerrando o sistema.");
        scanner.close();
    }

    private static void gerenciarProdutos(Scanner scanner) {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n--- Gestão de Produtos ---");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Buscar produto por código");
            System.out.println("4. Buscar produto por nome");
            System.out.println("5. Remover produto");
            System.out.println("6. Atualizar estoque");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> cadastrarProduto(scanner);
                case 2 -> listarProdutos();
                case 3 -> buscarProdutoPorCodigo(scanner);
                case 4 -> buscarProdutoPorNome(scanner);
                case 5 -> removerProduto(scanner);
                case 6 -> atualizarEstoque(scanner);
                case 0 -> menuAtivo = false;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarClientes(Scanner scanner) {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n--- Gestão de Clientes ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por nome");
            System.out.println("4. Buscar cliente por CPF");
            System.out.println("5. Remover cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> cadastrarCliente(scanner);
                case 2 -> listarClientes();
                case 3 -> buscarClientePorNome(scanner);
                case 4 -> buscarClientePorCpf(scanner);
                case 5 -> removerCliente(scanner);
                case 0 -> menuAtivo = false;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarVendas(Scanner scanner) {
        boolean menuAtivo = true;
        while (menuAtivo) {
            System.out.println("\n--- Gestão de Vendas ---");
            System.out.println("1. Realizar venda");
            System.out.println("2. Listar vendas");
            System.out.println("3. Histórico por cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> realizarVenda(scanner);
                case 2 -> listarVendas();
                case 3 -> historicoPorCliente(scanner);
                case 0 -> menuAtivo = false;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Preço: ");
        double preco = lerDouble(scanner);
        System.out.print("Quantidade em estoque: ");
        int estoque = lerInt(scanner);
        try {
            Produtos produto = Sistema.cadastrarProduto(nome, preco, estoque);
            System.out.println("Produto cadastrado: " + produto);
        } catch (IllegalArgumentException ex) {
            System.out.println("Falha ao cadastrar produto: " + ex.getMessage());
        }
    }

    private static void listarProdutos() {
        List<Produtos> produtos = Sistema.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("Produtos cadastrados:");
        for (Produtos produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void buscarProdutoPorCodigo(Scanner scanner) {
        System.out.print("Código do produto: ");
        int codigo = lerInt(scanner);
        Produtos produto = Sistema.buscarProdutoPorCodigo(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println(produto);
        }
    }

    private static void buscarProdutoPorNome(Scanner scanner) {
        System.out.print("Nome ou parte do nome: ");
        String nome = scanner.nextLine().trim();
        List<Produtos> resultados = Sistema.buscarProdutoPorNome(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        System.out.println("Produtos encontrados:");
        for (Produtos produto : resultados) {
            System.out.println(produto);
        }
    }

    private static void removerProduto(Scanner scanner) {
        System.out.print("Código do produto a remover: ");
        int codigo = lerInt(scanner);
        if (Sistema.removerProduto(codigo)) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void atualizarEstoque(Scanner scanner) {
        System.out.print("Código do produto: ");
        int codigo = lerInt(scanner);
        System.out.print("Quantidade para ajustar (use negativo para diminuir): ");
        int ajuste = lerInt(scanner);
        try {
            Sistema.atualizarEstoque(codigo, ajuste);
            Produtos produto = Sistema.buscarProdutoPorCodigo(codigo);
            System.out.println("Estoque atualizado: " + produto);
        } catch (IllegalArgumentException ex) {
            System.out.println("Falha ao atualizar estoque: " + ex.getMessage());
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine().trim();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine().trim();
        System.out.print("Telefone (opcional): ");
        String telefone = scanner.nextLine().trim();
        try {
            Clientes cliente = Sistema.cadastrarCliente(nome, cpf, telefone);
            System.out.println("Cliente cadastrado: " + cliente);
        } catch (IllegalArgumentException ex) {
            System.out.println("Falha ao cadastrar cliente: " + ex.getMessage());
        }
    }

    private static void listarClientes() {
        List<Clientes> clientes = Sistema.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("Clientes cadastrados:");
        for (Clientes cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void buscarClientePorNome(Scanner scanner) {
        System.out.print("Nome ou parte do nome: ");
        String nome = scanner.nextLine().trim();
        List<Clientes> resultados = Sistema.buscarClientePorNome(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }
        System.out.println("Clientes encontrados:");
        for (Clientes cliente : resultados) {
            System.out.println(cliente);
        }
    }

    private static void buscarClientePorCpf(Scanner scanner) {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine().trim();
        Clientes cliente = Sistema.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println(cliente);
        }
    }

    private static void removerCliente(Scanner scanner) {
        System.out.print("CPF do cliente a remover: ");
        String cpf = scanner.nextLine().trim();
        if (Sistema.removerCliente(cpf)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado ou CPF inválido.");
        }
    }

    private static void realizarVenda(Scanner scanner) {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine().trim();

        Map<Integer, Integer> itensPorCodigo = new HashMap<>();
        while (true) {
            System.out.print("Código do produto (0 para finalizar): ");
            int codigo = lerInt(scanner);
            if (codigo == 0) {
                break;
            }
            Produtos produto = Sistema.buscarProdutoPorCodigo(codigo);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }
            System.out.println(produto);
            System.out.print("Quantidade: ");
            int quantidade = lerInt(scanner);
            if (quantidade <= 0) {
                System.out.println("Quantidade inválida.");
                continue;
            }
            itensPorCodigo.put(codigo, itensPorCodigo.getOrDefault(codigo, 0) + quantidade);
        }

        if (itensPorCodigo.isEmpty()) {
            System.out.println("Nenhum item adicionado à venda.");
            return;
        }

        try {
            Vendas venda = Sistema.realizarVenda(cpf, itensPorCodigo);
            System.out.println("Venda realizada com sucesso:");
            System.out.println(venda);
        } catch (IllegalArgumentException ex) {
            System.out.println("Falha ao realizar venda: " + ex.getMessage());
        }
    }

    private static void listarVendas() {
        List<Vendas> vendas = Sistema.listarVendas();
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        System.out.println("Vendas registradas:");
        for (Vendas venda : vendas) {
            System.out.println(venda);
            System.out.println();
        }
    }

    private static void historicoPorCliente(Scanner scanner) {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine().trim();
        List<Vendas> vendas = Sistema.historicoPorCliente(cpf);
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda encontrada para este cliente.");
            return;
        }
        System.out.println("Histórico de vendas do cliente:");
        for (Vendas venda : vendas) {
            System.out.println(venda);
            System.out.println();
        }
    }

    private static int lerInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Entrada inválida. Digite um número inteiro: ");
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.print("Entrada inválida. Digite um número válido: ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}
