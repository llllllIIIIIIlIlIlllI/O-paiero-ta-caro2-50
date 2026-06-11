const readline = require("readline/promises");
const {stdin, stdout} = require("process");

const rl = readline.createInterface ({
    input: stdin,
    output: stdout,
});

async function main() {

    const nome = await rl.question("Digite seu nome: ");
    const idade = await rl.question("Digite sua idade: ");
    const cidade = await rl.question("Digite sua cidade: ");

    console.log("\nDados informados: ");
    console.log("Idade: ", idade);
    console.log("Nome: ", nome);
    console.log("Cidade: ", cidade);

    rl.close();

}

main();