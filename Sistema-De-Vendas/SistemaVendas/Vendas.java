package SistemaVendas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Vendas {
    private static int nextId = 1;
    private static final ArrayList<Vendas> vendas = new ArrayList<>();
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final int id;
    private final Clientes cliente;
    private final List<ItemVenda> itens;
    private final LocalDateTime data;

    public Vendas(Clientes cliente) {
        this.id = nextId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.data = LocalDateTime.now();
    }

    public void adicionarItem(Produtos produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto inválido.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (produto.getEstoque() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        produto.atualizarEstoque(-quantidade);
        itens.add(new ItemVenda(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public static Vendas realizarVenda(Clientes cliente, Map<Integer, Integer> itensPorCodigo) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido.");
        }
        if (itensPorCodigo == null || itensPorCodigo.isEmpty()) {
            throw new IllegalArgumentException("Nenhum item adicionado na venda.");
        }
        Vendas venda = new Vendas(cliente);
        for (Map.Entry<Integer, Integer> entrada : itensPorCodigo.entrySet()) {
            int codigo = entrada.getKey();
            int quantidade = entrada.getValue();
            Produtos produto = Produtos.buscarPorCodigo(codigo);
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado: código " + codigo);
            }
            venda.adicionarItem(produto, quantidade);
        }
        vendas.add(venda);
        return venda;
    }

    public static List<Vendas> listarVendas() {
        return Collections.unmodifiableList(vendas);
    }

    public static List<Vendas> historicoPorCliente(String cpf) {
        ArrayList<Vendas> resultado = new ArrayList<>();
        for (Vendas venda : vendas) {
            if (venda.cliente.getCpf().equals(cpf.trim())) {
                resultado.add(venda);
            }
        }
        return resultado;
    }

    public int getId() {
        return id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Venda %d | Cliente: %s | CPF: %s | Data: %s\n",
                id,
                cliente.getNome(),
                cliente.getCpf(),
                data.format(FORMATO_DATA)));
        for (ItemVenda item : itens) {
            builder.append("  - ").append(item).append("\n");
        }
        builder.append(String.format("Total: R$ %.2f", calcularTotal()));
        return builder.toString();
    }
}

class ItemVenda {
    private final Produtos produto;
    private final int quantidade;

    public ItemVenda(Produtos produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s (x%d) - R$ %.2f", produto.getNome(), quantidade, getSubtotal());
    }
}
