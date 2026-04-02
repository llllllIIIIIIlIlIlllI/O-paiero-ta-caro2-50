import java.util.ArrayList;
import java.time.LocalDate;
public class Conta {
    private double saldo;
    private String numeroConta;
    private Historico historico;


    public double getSaldo() {
        return this.saldo;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    // Operações

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo || valor <= 0) {
            return false;
        }
        this.saldo -= valor;
        LocalDate dataSaque = LocalDate.now();
        return true;
    }

    public String descricao() {
        return "Conta";
    }
}
