package SistemaVendas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clientes {
    private static final String CLIENTES_FILE_NAME = "clientes.txt";
    private static final ArrayList<Clientes> clientes = new ArrayList<>();

    static {
        carregarClientesDoArquivo();
    }

    private final String cpf;
    private String nome;
    private String telefone;

    public Clientes(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public static Clientes cadastrar(String nome, String cpf, String telefone) {
        if (!Sistema.isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome do cliente inválido.");
        }
        if (!Sistema.validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos e ser um CPF válido.");
        }
        cpf = limparCpf(cpf);
        if (buscarPorCpf(cpf) != null) {
            throw new IllegalArgumentException("Já existe cliente cadastrado com este CPF.");
        }
        Clientes cliente = new Clientes(nome.trim(), cpf, telefone == null ? "" : telefone.trim());
        clientes.add(cliente);
        try {
            salvarClientesEmArquivo();
        } catch (IOException e) {
            clientes.remove(cliente);
            throw new RuntimeException("Falha ao salvar cliente no arquivo: " + e.getMessage(), e);
        }
        return cliente;
    }

    public static List<Clientes> listar() {
        return Collections.unmodifiableList(clientes);
    }

    public static List<Clientes> buscarPorNome(String nome) {
        ArrayList<Clientes> resultado = new ArrayList<>();
        String consulta = nome == null ? "" : nome.trim().toLowerCase();
        for (Clientes cliente : clientes) {
            if (cliente.nome.toLowerCase().contains(consulta)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    public static Clientes buscarPorCpf(String cpf) {
        String consulta = limparCpf(cpf);
        for (Clientes cliente : clientes) {
            if (cliente.cpf.equals(consulta)) {
                return cliente;
            }
        }
        return null;
    }

    public static boolean remover(String cpf) {
        Clientes cliente = buscarPorCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            try {
                salvarClientesEmArquivo();
            } catch (IOException e) {
                clientes.add(cliente);
                throw new RuntimeException("Falha ao salvar clientes após remoção: " + e.getMessage(), e);
            }
            return true;
        }
        return false;
    }

    private static void carregarClientesDoArquivo() {
        File arquivo = new File(CLIENTES_FILE_NAME);
        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo, StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("NOME;CPF;TELEFONE")) {
                    continue;
                }
                String[] partes = linha.split(";", -1);
                if (partes.length < 3) {
                    continue;
                }
                String nome = partes[0].trim();
                String cpf = limparCpf(partes[1]);
                String telefone = partes[2].trim();
                if (!Sistema.isNomeValido(nome) || !Sistema.validarCpf(cpf)) {
                    continue;
                }
                if (buscarPorCpf(cpf) == null) {
                    clientes.add(new Clientes(nome, cpf, telefone));
                }
            }
        } catch (IOException e) {
            System.err.println("Falha ao carregar clientes do arquivo: " + e.getMessage());
        }
    }

    private static void salvarClientesEmArquivo() throws IOException {
        File arquivo = new File(CLIENTES_FILE_NAME);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, StandardCharsets.UTF_8))) {
            writer.write("NOME;CPF;TELEFONE");
            writer.newLine();
            for (Clientes cliente : clientes) {
                writer.write(formatarLinha(cliente));
                writer.newLine();
            }
        }
    }

    private static String formatarLinha(Clientes cliente) {
        return String.join(";",
                escaparTexto(cliente.nome),
                cliente.cpf,
                escaparTexto(cliente.telefone));
    }

    private static String escaparTexto(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace(";", ",").replaceAll("[\r\n]+", " ").trim();
    }

    private static String limparCpf(String cpf) {
        if (cpf == null) {
            return "";
        }
        return cpf.replaceAll("\\D", "");
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | CPF: %s | Telefone: %s", nome, cpf, telefone == null || telefone.isBlank() ? "-" : telefone);
    }
}
