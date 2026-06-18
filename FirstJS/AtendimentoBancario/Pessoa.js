class Pessoa {
    constructor(nome, idade, raca, nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.nacionalidade = nacionalidade;
    }

    exibirPessoa() {
        console.log("Nome: " + this.nome);
        console.log("Idade: " + this.idade);
        console.log("Raca: " + this.raca);
        console.log("Nacionalidade: " + this.nacionalidade);
    }
}

function main() {
    const pessoa1 = new Pessoa("João", 30, "Branco", "Brasileiro");
    pessoa1.exibirPessoa();
}
module.exports = Pessoa;