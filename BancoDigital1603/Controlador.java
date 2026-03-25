package BancoDigital1603;

import java.util.Scanner;

public class Controlador {
    private Cliente cliente;
    private Telas telas;
    private static final Scanner sc = new Scanner(System.in);

    public Controlador(Cliente cliente, Telas telas) {
        this.cliente = cliente;
        this.telas = telas;

    }

    public void CriarConta() {

        Telas.mostrarMensagem("Criar conta: ");

        System.out.print("Digite aqui o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite aqui a data de nascimento (dd/mm/yyyy)");
        String dataNascimento = sc.nextLine();

        System.out.println("Digite aqui o CPF: ");
        String cpf = sc.nextLine();

        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);
        cliente.setCpf(cpf);
    }
}
