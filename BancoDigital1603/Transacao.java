import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Transacao representa uma única movimentação financeira.
 *
 * Composição: Historico TEM uma lista de Transacao.
 * Cada Transacao é um objeto independente com seus próprios dados;
 * ela não sabe da existência do Historico — apenas armazena informações.
 */
public class Transacao {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String tipo;
    private double valor;
    private LocalDate data;

    public Transacao(String tipo, double valor, LocalDate data) {
        this.tipo  = tipo;
        this.valor = valor;
        this.data  = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    /* Representação formatada para exibição no extrato. */
    @Override
    public String toString() {
        return String.format("%-22s  R$ %10.2f   %s",
                tipo, valor, data.format(FORMATADOR));
    }
}
