package BancoDigital1603;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cliente {
    private static final int IDADE_MINIMA = 16;
    private static final int ANO_MINIMO = 1900;
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String numeroConta;
    private String senha;
    private double saldo;
    private boolean bloqueada;
    private int tentativasFalhas;

    Scanner sc = new Scanner(System.in);

    // Fazendo os getters.
    public String getNome() {
        return nome;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Fazendo os setters.
    public boolean setNome(String nome) {
        /// Fiz essa validação aqui, com ajuda do chatgpt, porém entendi a lógica, caso
        /// nome for nulo ou os espaços do nome forem empty, vai avisar que o nome não
        /// pode ser vazio, ou nulo.
        if (nome == null || nome.trim().split("\\s+").lengt < 2) {
            return false;
        }
        this.nome = nome.trim();
        return true;
    }

    /// Aqui vai validar o cpf, pra ver se ele realmente existe e está no padrão
    /// correto brasileiro atual.
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /// Aqui irá validar pra ver se a data realmente existe, se ela é válida, etc...
    public boolean setDataNascimento(String data) {
        if (data == null) 
            return false;
        try {
            LocalDate hoje = LocalDate.now();
            LocalDate dataNascimento = LocalDate.parse(data, formatador);
            

            if (dataNascimento.getYear() < ANO_MINIMO)
                return false;

            LocalDate idadeMinima = hoje.minusYears(IDADE_MINIMA);
            if (dataNascimento.isAfter(idadeMinima)) {
                return false;
            }
            this.dataNascimento = dataNascimento;
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void registrarTentativasFalhas() {
        while (tentativasFalhas < 5) {
            System.out.print("Digite aqui sua senha: ");
            String senhaInformada = sc.next();
            if (senhaInformada.equals(senha)) {
                System.out.println("Senha correta.");
                tentativasFalhas = 0;
                bloqueada = false;
                return;
            } else if (!senhaInformada.equals(senha)) {
                tentativasFalhas += 1;
                System.out.println("Senha incorreta.");
                if (tentativasFalhas == 3) {
                    System.out.println("Sua conta foi bloqueada, para desbloquear vá até uma agência da instituição.");
                    bloqueada = true;
                    break;
                }
            }
        }
    }
}
