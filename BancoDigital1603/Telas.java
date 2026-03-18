package BancoDigital1603;

public class Telas {

        private Cliente cliente;

        public Telas (Cliente cliente) {
                this.cliente = cliente;
        }


        public static void MenuPrincipal() {
                System.out.println("=== MENU PRINCIPAL ===");
                System.out.println("1 - Criar conta");
                System.out.println("2 - Acessar conta");
                System.out.println("3 - Encerrar");
                System.out.print("Escolha: ");
        }

        public void MenuConta() {
                System.out.println("===============");
                System.out.println("Bem vindo, " + cliente.getNome());
                System.out.println("Saldo: R$ ");
                System.out.println("===============");
                System.out.println("1 - Sacar");
                System.out.println("2 - Depositar");
                System.out.println("3 - Transferir");
        }

}