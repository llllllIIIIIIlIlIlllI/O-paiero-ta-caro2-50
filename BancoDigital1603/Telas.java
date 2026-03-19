package BancoDigital1603;

import java.util.Scanner;

public class Telas {
        Cliente cliente;
        private static final Scanner sc = new Scanner(System.in);

        public Telas(Cliente cliente) {
                this.cliente = cliente;
        }

        public static String lerTexto(String label) {
                System.out.println(label + ": ");
                return sc.nextLine().trim();
        }

        public static double lerValor(String label) {
                System.out.println(label + ": ");
                try {
                        return Double.parseDouble(sc.nextLine().trim().replace(".", ","));
                } catch (NumberFormatException e) {
                        return -1;
                }
        }

        public void mostrarMensagem(String msg) {
                System.out.println(msg);
        }

        public void mostrarMensagemErro(String msg) {
                limparTela();
                System.out.println("Erro: " + msg);
                System.out.println("Pressione qualquer tecla para continuar...");
                sc.nextLine();
        }

        private static void limparTela() {
                for (int i = 0; i < 50; i++) {
                        System.out.println();
                }
        }

        public static int lerOpcao() {
                int opcao = sc.nextInt();
                sc.nextLine();
                return opcao;
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
                System.out.println("Saldo: R$ " + cliente.getSaldo());
                System.out.println("===============");
                System.out.println("1 - Sacar");
                System.out.println("2 - Depositar");
                System.out.println("3 - Transferir");
        }

}