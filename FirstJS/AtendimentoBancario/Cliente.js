const Pessoa = require('./Pessoa');

class Cliente extends Pessoa {
    static contadorComum = 0;
    static contadorPrioritario = 0;

    static TipoCliente = Object.freeze({
        COMUM: 'comum',
        PRIORITARIO: 'prioritario'

    });
    constructor(nome, idade, raca, nacionalidade, tipo) {
        super(nome, idade, raca, nacionalidade);
        this.tipo = tipo;
    }

    static gerarSenha(tipo) {
        if (tipo === Cliente.TipoCliente.PRIORITARIO) {
            Cliente.contadorPrioritario++;
            return `P${Cliente.contadorPrioritario.toString().padStart(3, '0')}`;
        }

        Cliente.contadorComum++;
        return `C${Cliente.contadorComum.toString().padStart(3, '0')}`;
    }

    exibirCliente() {
        console.log(this.nome, this.idade, this.raca, this.nacionalidade, senha);
    }
}
function main() {
    const clientes = [
        new Cliente("Caio", 19, "Preto", "Bolsonaro", "PRIORITARIO"),
        new Cliente("João", 25, "Branco", "Brasileiro", "PBAIXO"),
        new Cliente("Maria", 30, "Parda", "Brasileira", "PBAIXA"),
        new Cliente("Ana", 40, "Preta", "Brasileira", "PRIORITARIO")
    ];

    for (const cliente of clientes) {
        cliente.exibirCliente();
    }
}
main();