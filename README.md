# Caixa Eletrônico 

## Objetivo

Desenvolva um programa que simule a entrega de notas quando um cliente efetuar um saque em um caixa eletrônico. Os requisitos básicos são os seguintes:

1. Entregar o menor número de notas;
2. É possível sacar o valor solicitado com as notas disponíveis;
3. Saldo do cliente infinito;
4. Quantidade de notas infinito (pode-se colocar um valor finito de cédulas para aumentar a dificuldade do problema);
5. Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00

Exemplos:

- Valor do Saque: R$ 30,00 – Resultado Esperado: Entregar 1 nota de R$20,00 e 1 nota de R$ 10,00.
- Valor do Saque: R$ 80,00 – Resultado Esperado: Entregar 1 nota de R$50,00 1 nota de R$ 20,00 e 1 nota de R$ 10,00.

## Organização do Código

O código foi organizado da seguinte maneira:

#### Pacotes

Foram criados dois pacotes para a melhor organização das classes

- com.barbsmfe.cashMachine.controller 
        Neste pacote está a classe Main, responsável pela execução do código e também a classe AppConfig, usada para injeção de dependências com Spring.
- com.barbsmfe.cashMachine.domain
        Neste pacote está a classe CashMachine, nesta classe estão os algoritmos que concluem o objetivo desde exercício.
- com.barbsmfe.cashMachine.test
        Neste pacote estão os testes criados para a validação dos algoritmos, utilizando JUnit 5.

## Lógica do Algoritmo Criado

Primeiramente a aplicação verifica se o valor desejado pelo usuário é um valor válido, ou seja, se é um valor:

- Maior que zero
- Disivível por dez

Caso o valor seja validado, ele entra em um algoritmo recursivo responsável por encontrar o menor número possível de notas (dentro das disponíveis) que possa ser devolvido para o usuário. Abaixo uma descrição do mesmo em português estruturado:

        Algoritmo: getLeastNumberOfBanknotes(valorDesejado : inteiro, mapaMenorQuantidadeNotas : Map)
            - INÍCIO
               - Condição de parada: 
                      SE valorDesejado = 0 ENTÃO RETORNA mapaMenorQuantidadeNotas
               - Encontrar a primeira nota a ser subtraída do valorDesejado, deve ser a maior possível das disponíveis que seja menor que o valorDesejado
               - Colocar a nota encontrada acima dentro de mapaMenorQuantidadesNotas
               - Chama o método getLeastNumberOfBanknotes (ele mesmo) passando como parâmetro: (valorDesejado - notaEncontradaAcima) e mapaMenorQuantidadeNotas
               - RETORNA mapaMenorQUantidadeNotas
            - FIM

## Forma de Execução

O algoritmo pode ser testado e executado através de uma IDE, foi utilizado o Gradle para as dependências então a importação do projeto deve levar isso em conta. A IDE utilizada para o feitio desde código foi o Eclipse.

Ao executar o programa, aparecerá em tela a seguinte mensagem: 

- Type the value you wish to take from this cash machine: 

O usuário deve então digitar o valor desejado e apertar a tecla Enter, após isso, caso o valor seja válido, o Map gerado pelo programa aparecerá em tela, mostrando como chaves os valores das notas disponíveis, e como valores as quantidades dessas notas que foram devolvidas. 

Exemplo de execução:

Type the value you wish to take from this cash machine: 
80
-- NUMBER OF BANKNOTES --
{50=1, 100=0, 20=1, 10=1}





