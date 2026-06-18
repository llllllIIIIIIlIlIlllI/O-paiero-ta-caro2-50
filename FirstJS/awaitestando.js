function esperar(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
}

async function exemploDeEspera() {
    console.log("1 - começo");

    await esperar(2000);

    console.log("2 - depois de 2 segundos");
    console.log("3 - fim");
}

exemploDeEspera();
console.log("Isso aparece ANTES ou DEPOIS da contagem de tempo?")