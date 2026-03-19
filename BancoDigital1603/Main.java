package BancoDigital1603;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        int opcao = 0;
            do {
            Telas.MenuPrincipal();
            opcao = Telas.lerOpcao();
            switch (opcao) {
                
                case 1:
                    /// Lógica de cadastrar conta
                    System.out.println("WIP");
                    break;
                case 2:
                    /// Lógica de acessar conta
                    System.out.println("WIP");
                    c1.setSenha("192020");
                    c1.registrarTentativasFalhas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println(opcao);
                    break;
            }
        } while (opcao != 3);
    }
}