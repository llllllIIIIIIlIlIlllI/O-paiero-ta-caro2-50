# Descrição do processo de resolução

## Objetivo
Resolver o problema do beecrowd que pede a soma dos 5 números pares consecutivos a partir de um valor inteiro `X`, inclusive `X` quando ele já é par.

## O que foi feito

1. Li o enunciado no arquivo `SomaDiPares/desafio-beecrowded.md`.
2. Entendi a regra de saída:
   - Ler valores inteiros indefinidamente até encontrar `0`.
   - Para cada valor diferente de `0`, calcular a soma dos 5 pares consecutivos a partir desse valor.
   - Se o valor for ímpar, usar o próximo número par como ponto de partida.
3. Implementei o código em `SomaDiPares/submission/Main.java` usando `BufferedReader` para ler a entrada padrão linha por linha.
4. Em cada linha:
   - Removi espaços em branco.
   - Ignorei linhas vazias.
   - Converti o texto para inteiro e, em caso de entrada inválida, continuei para a próxima linha.
   - Parei a leitura ao encontrar o valor `0`.
5. Calculei a soma dos 5 pares consecutivos de forma direta:
   - `x + (x + 2) + (x + 4) + (x + 6) + (x + 8)`.
6. Imprimi cada resultado em uma linha separada, como o beecrowd exige.

## Testes realizados

Usei o exemplo do enunciado para verificar a solução:

Entrada:
```
4
11
0
```
Saída esperada:
```
40
80
```

O teste foi executado com sucesso.

## Observações

- O programa não usa pacotes personalizados: está pronto para submissão no formato exigido pelo beecrowd.
- O arquivo `SomaDiPares/submission/README.md` contém instruções de compilação e execução.
