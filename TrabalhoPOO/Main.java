package TrabalhoPOO;

public class Main {
    public static void main(String[] args) {
        /// Aqui estou criando uma nova conta bancaria, utilizando meu nome, e um saldo de R$0.0
        ContaBancaria p1 = new ContaBancaria("Caio" ,0);
        /// Vou deixar comentado aqui o que acontece caso deixamos um dado do objeto como private.
        /// p1.saldo = 1000000000000;
        
        p1.SetSaldo(1500);
        /// Aqui utilizei a função de sacar.
        p1.Depositar(1500);
        p1.Depositar(980);
        /// Aqui eu uso o método de exibir saldo.
        System.out.println("======================");
        System.out.println("Seu atual saldo:");
        p1.ExibirSaldo();
        System.out.println("======================");

        p1.VerExtrato();
    }
}