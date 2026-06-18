const readline = require("readline/promises");
const { stdin, stdout } = require("process");

const rl = readline.createInterface({
    input: stdin,
    output: stdout,
});

async function main() {
    let strengue = await rl.question ("Digite a frase/palavra desejada para inverter: ");
    console.log(strengue);
    let aux = "";
    for (let i = strengue.length - 1; i >= 0; i--) {
        aux += strengue[i];
    }
    console.log(aux);
    rl.close();



}

main();
console.log("AAAAAAAAAAAAAA")