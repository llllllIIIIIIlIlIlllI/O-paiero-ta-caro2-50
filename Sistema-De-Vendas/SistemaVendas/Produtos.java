package SistemaVendas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produtos {
    private static int nextCodigo = 1;
    private static final ArrayList<Produtos> produtos = new ArrayList<>();

    private final int codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produtos(String nome, double preco, int estoque) {
        this.codigo = nextCodigo++;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static Produtos cadastrar(String nome, double preco, int estoque) {
        if (!Sistema.isNomeValido(nome)) {
            throw new IllegalArgumentException("Nome do produto inválido.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço do produto deve ser maior que zero.");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque do produto não pode ser negativo.");
        }
        Produtos produto = new Produtos(nome, preco, estoque);
        produtos.add(produto);
        return produto;
    }

    public static List<Produtos> listar() {
        return Collections.unmodifiableList(produtos);
    }

    public static Produtos buscarPorCodigo(int codigo) {
        for (Produtos produto : produtos) {
            if (produto.codigo == codigo) {
                return produto;
            }
        }
        return null;
    }

    public static List<Produtos> buscarPorNome(String nome) {
        ArrayList<Produtos> resultado = new ArrayList<>();
        String consulta = nome.trim().toLowerCase();
        for (Produtos produto : produtos) {
            if (produto.nome.toLowerCase().contains(consulta)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public static boolean remover(int codigo) {
        Produtos produto = buscarPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    public boolean atualizarEstoque(int quantidade) {
        if (this.estoque + quantidade < 0) {
            return false;
        }
        this.estoque += quantidade;
        return true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d", codigo, nome, preco, estoque);
    }
}
