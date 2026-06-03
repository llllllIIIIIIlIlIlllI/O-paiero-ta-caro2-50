package SistemaVendas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Sistema {
    public static Clientes cadastrarCliente(String nome, String cpf, String telefone) {
        nome = nome == null ? "" : nome.trim();
        cpf = limparCpf(cpf);
        telefone = telefone == null ? "" : telefone.trim();

        if (!isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome do cliente inválido.");
        }
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos e ser um CPF válido.");
        }
        if (Clientes.buscarPorCpf(cpf) != null) {
            throw new IllegalArgumentException("Já existe cliente cadastrado com este CPF.");
        }

        return Clientes.cadastrar(nome, cpf, telefone);
    }

    public static List<Clientes> listarClientes() {
        return Clientes.listar();
    }

    public static List<Clientes> buscarClientePorNome(String nome) {
        if (nome == null) {
            return Collections.emptyList();
        }
        return Clientes.buscarPorNome(nome);
    }

    public static Clientes buscarClientePorCpf(String cpf) {
        return Clientes.buscarPorCpf(limparCpf(cpf));
    }

    public static boolean removerCliente(String cpf) {
        if (!validarCpf(cpf)) {
            return false;
        }
        return Clientes.remover(limparCpf(cpf));
    }

    public static Produtos cadastrarProduto(String nome, double preco, int estoque) {
        nome = nome == null ? "" : nome.trim();

        if (!isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome do produto inválido.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço do produto deve ser maior que zero.");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque do produto não pode ser negativo.");
        }

        return Produtos.cadastrar(nome, preco, estoque);
    }

    public static List<Produtos> listarProdutos() {
        return Produtos.listar();
    }

    public static Produtos buscarProdutoPorCodigo(int codigo) {
        if (codigo <= 0) {
            return null;
        }
        return Produtos.buscarPorCodigo(codigo);
    }

    public static List<Produtos> buscarProdutoPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return Produtos.buscarPorNome(nome);
    }

    public static boolean removerProduto(int codigo) {
        if (codigo <= 0) {
            return false;
        }
        return Produtos.remover(codigo);
    }

    public static boolean atualizarEstoque(int codigo, int ajuste) {
        Produtos produto = Produtos.buscarPorCodigo(codigo);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        if (ajuste == 0) {
            throw new IllegalArgumentException("Ajuste de estoque deve ser diferente de zero.");
        }
        if (!produto.atualizarEstoque(ajuste)) {
            throw new IllegalArgumentException("Ajuste inválido. Estoque não pode ficar negativo.");
        }
        return true;
    }

    public static Vendas realizarVenda(String cpf, Map<Integer, Integer> itensPorCodigo) {
        cpf = limparCpf(cpf);
        Clientes cliente = buscarClientePorCpf(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        if (itensPorCodigo == null || itensPorCodigo.isEmpty()) {
            throw new IllegalArgumentException("Nenhum item adicionado na venda.");
        }

        for (Map.Entry<Integer, Integer> entrada : itensPorCodigo.entrySet()) {
            if (entrada.getKey() <= 0 || entrada.getValue() <= 0) {
                throw new IllegalArgumentException("Itens inválidos na venda. Código e quantidade devem ser maiores que zero.");
            }
            Produtos produto = Produtos.buscarPorCodigo(entrada.getKey());
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado: código " + entrada.getKey());
            }
            if (produto.getEstoque() < entrada.getValue()) {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
            }
        }

        return Vendas.realizarVenda(cliente, itensPorCodigo);
    }

    public static List<Vendas> listarVendas() {
        return Vendas.listarVendas();
    }

    public static List<Vendas> historicoPorCliente(String cpf) {
        if (!validarCpf(cpf)) {
            return Collections.emptyList();
        }
        return Vendas.historicoPorCliente(limparCpf(cpf));
    }

    public static boolean validarCpf(String cpf) {
        if (cpf == null) {
            return false;
        }
        String numeros = limparCpf(cpf);
        if (numeros.length() != 11) {
            return false;
        }
        if (numeros.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Character.getNumericValue(numeros.charAt(i));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigitoVerificador = resto < 2 ? 0 : 11 - resto;
        if (digitos[9] != primeiroDigitoVerificador) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }
        resto = soma % 11;
        int segundoDigitoVerificador = resto < 2 ? 0 : 11 - resto;
        return digitos[10] == segundoDigitoVerificador;
    }

    public static String limparCpf(String cpf) {
        if (cpf == null) {
            return "";
        }
        return cpf.replaceAll("\\D", "");
    }

    public static boolean isNomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
}
