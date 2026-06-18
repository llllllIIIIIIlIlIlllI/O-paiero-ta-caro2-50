async function buscarEndereco(cep) {
    console.log(`Buscando endereço do CEP ${cep}...`)

    const resposta = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
    const endereco = await resposta.json();

    console.log(`Endereço encontrado: ${endereco.logradouro}, ${endereco.localidade} - ${endereco.uf}`);
    return endereco;
}

buscarEndereco(74987210)