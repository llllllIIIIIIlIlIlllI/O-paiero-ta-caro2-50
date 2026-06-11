const readline = require("readline/promises");
const {stdin, stdout} = require("process");

const rl = readline.createInterface ({
    input: stdin,
    output: stdout,
});

async function main () {
    let num1 = await rl.question("Digite o primeiro número: ");
    let num2 = await rl.question("Digite o segundo número: ");
    let num3 = await rl.question("Digite o terceiro número: ");
    num1 = Number(num1);
    num2 = Number(num2);
    num3 = Number(num3);

    if (num1 > num2 && num1 > num3) {
        console.log("O maior número é: ", num1, " 🏆");
    } else if (num2 > num1 && num2 > num3) {
        console.log("O maior número é: ", num2, " 🏆");
    } else if (num3 > num1 && num3 > num2) {
        console.log("O maior número é: ", num3, " 🏆");
    }

    rl.close();
} main();