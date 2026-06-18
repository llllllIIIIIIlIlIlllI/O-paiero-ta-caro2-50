const Pessoa = require('.Pessoa');

class Atendente extends Pessoa {
    constructor (nome, cpf) {
        super(nome, cpf);
        this.matricula = matricula;
        this.historico = []
    }

    atender() {
        console.log(`Atendente ${this.nome} atendendo cliente ${cliente.nome}`);
        this.historico.push(cliente);
    }

    relatorio() {
        console.log(`Relatório de atendimento do atendente ${this.nome}:`)
        console.log(`Total de atendimentos: ${this.historico.length}\n`)

        if(this.historico.length > 0) {
            this.historico.forEach((cliente, index) => {
                console.log(`Atendimeto ${index + 1}: \t ${cliente.tipo} \t ${cliente.nome}`)
            })
        } else {
            console.log("Nenhum atendimento registrado.")
        }
    }
}

module.exports = Atendente;