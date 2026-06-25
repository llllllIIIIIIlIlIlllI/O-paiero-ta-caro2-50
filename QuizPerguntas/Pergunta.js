export class Pergunta {
    constructor(texto, alternativas, respostaCorreta) {
        this.texto = texto;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    estaCorreta (indiceEscolhido) {
        if (indiceEscolhido === respostaCorreta) {
            let jogadorAcertou = true;
        }
    }
}