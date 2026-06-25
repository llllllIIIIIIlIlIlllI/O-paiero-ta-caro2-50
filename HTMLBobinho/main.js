console.log("Script executado com sucesso");
const form = document.querySelector('#form-nome');
const historico = document.querySelector('#historico');
const saudacao = document.querySelector('#saudacao');

form.addEventListener("submit", function (event) {
    // Evita o recarregamento da página
    event.preventDefault();

    const campoNome = document.querySelector("#nome");
    const nomeDigitado = campoNome.value.trim();

    if (nomeDigitado === "") {
        saudacao.textContent = "Por favor, digite seu nome!";
        return;
    }

    // 1. Define o texto de saudação principal
    const mensagem = `Olá, ${nomeDigitado}!`;
    saudacao.textContent = mensagem;

    // 2. Cria um novo elemento <li> de forma dinâmica
    const novoItem = document.createElement("li");
    novoItem.textContent = mensagem; // Define o texto do item da lista

    // 3. Adiciona o novo <li> dentro do <ul> (histórico) sem apagar os anteriores
    historico.appendChild(novoItem);

    // Opcional: Limpa o campo de texto para a próxima digitação
    campoNome.value = "";
    campoNome.focus();
});