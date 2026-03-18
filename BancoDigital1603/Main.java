package BancoDigital1603;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);

        do {
            Telas.MenuPrincipal();
            opcao = sc.nextInt();
            switch (opcao) {

                case 1:
                    /// Lógica de cadastrar conta
                    System.out.println();
                    break;
                case 2:
                    /// Lógica de acessar conta
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao < 3);
    }
}