package BancoDigital1603;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Cliente(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Fazendo os getters.
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    // Fazendo os setters.
    public void setNome(String nome) {
        /// Fiz essa validação aqui, com ajuda do chatgpt, porém entendi a lógica, caso nome for nulo ou os espaços do nome
        /// forem empty, vai avisar que o nome não pode ser vazio, ou nulo.
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio, ou nulo.");
        }
        this.nome = nome;
    }
    /// Aqui vai validar o cpf, pra ver se ele realmente existe e está no padrão correto brasileiro atual.
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /// Aqui irá validar pra ver se a data realmente existe, se ela é válida, etc...
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}