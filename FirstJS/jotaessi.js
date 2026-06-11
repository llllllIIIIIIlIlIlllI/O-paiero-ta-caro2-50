const readline = require("readline/promises");
const {stdin, stdout} = require("process");

const rl = readline.createInterface ({
    input: stdin,
    output: stdout,
});

async function main() {
    const String = ("Mamãe eu to com fome");
    const Number = 18;
    const NumberDecimal = 1.24;
    let Undefined;
    const Null = null;
    const obj = {
        pessoa: ("João"),
    }
    const listt = ["Bolsonaro", "Lula", "Fábio de Melo"];
    const boolean = true;

    console.log(typeof String);
    console.log(typeof Number);
    console.log(typeof NumberDecimal);
    console.log(typeof Undefined);
    console.log(typeof Null);
    console.log(typeof obj);
    console.log(typeof listt);
    console.log(typeof boolean);

    rl.close();

}

main();