package TrabalhoPOO;
public class ContaBancaria {
    String clienteTitular;
    private double saldo;
    /// Aqui fica o método construtor.
    ContaBancaria(String clienteTitular, double saldo) {
        this.clienteTitular = clienteTitular;
        this.saldo = saldo;
    }
    /// Aqui fica a função de depositar, o saldo só consegue ser acessado depositando ou sacando "dinheiro".
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
