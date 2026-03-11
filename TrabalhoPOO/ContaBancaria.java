package TrabalhoPOO;
public class ContaBancaria {
    String clienteTitular;
    private double saldo;
    /// Aqui fica o método construtor.
    ContaBancaria(String clienteTitular, double saldo) {
        this.clienteTitular = clienteTitular;
        this.saldo = saldo;
    }
    /// Aqui eu criei um metódo para setar o saldo no programa.
    double SetSaldo(double SaldoFinal){
        if (saldo >= 0) {
            saldo = SaldoFinal;
        } else {
            System.out.println("Saldo inválido.");
        } return SaldoFinal;
    }
    /// Aqui fica a função de depositar, o saldo só consegue ser acessado depositando ou sacando "dinheiro", ou usando a função de set.
    double Depositar (double valor) {
        saldo += valor;
        return valor;
    }
    /// Aqui fica a função de sacar.
    double Sacar (double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque feito com sucesso! Você sacou: " + valor);
        } else {
            System.out.println("Você não tem isso tudo de dinheiro!");
        } return valor;
    }
    /// Aqui fica a função de exibir o saldo.
    public void ExibirSaldo () {
        System.out.println(clienteTitular);
        System.out.println(saldo);
    }
}
