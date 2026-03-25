package BancoDigital1603;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Telas telas = new Telas(cliente);
        Controlador controlador = new Controlador(cliente, telas);
        int opcao = 0;
        do {
            Telas.MenuPrincipal();
            opcao = Telas.lerOpcao();
            switch (opcao) {

                case 1:
                    controlador.CriarConta();
                    System.out.println("WIP");
                    break;
                case 2:
                    /// Lógica de acessar conta
                    System.out.println("WIP");
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