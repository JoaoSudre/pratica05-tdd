# Respostas Pratica05-tdd

## 1) No Ciclo 1 usamos return 70. Por que isso é aceitável no TDD? O que obrigou a escrever a soma de verdade?
No TDD, a fase green exige que escrevamos apenas o mínimo código necessário para fazer o teste passar. Retornar um valor fixo é aceitável porque valida o ciclo inicial de feedback e garante que a infraestrutura de testes está a funcionar. O que obrigou a escrever a soma de verdade foi o Ciclo 2, onde introduzimos um segundo caso de teste com valores diferentes, tornando insustentável o uso de um valor fixo e forçando a implementação da verdadeira logica.

## 2) No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90?
Porque 69 e 70 testam a fronteira exata da regra de aprovação estabelecida. Testar com 50 ou 90 validaria apenas se valores distantes são reprovados ou aprovados, mas falharia em detetar um erro comum de lógica, como o programador utilizar acidentalmente o operador estritamente maior em vez de maior ou igual.

## 3) No Ciclo 4, o que mudou na refatoração? Como você teve certeza de que não quebrou nada?
Na refatoração, eliminou a duplicação de código criando um método auxiliar privado, substituindo três blocos if repetidos por chamadas limpas a esse método. A certeza de que nada foi quebrado veio através da execução contínua da suite de testes pelo frasquinho do VS Code, cujos resultados verdes confirmaram que o comportamento do sistema permaneceu intacto após a alteração.

## 4) No Ciclo 8, por que alteramos os testes antes de mudar o código?
Porque no ciclo de desenvolvimento guiado por testes, os testes funcionam como a especificação do comportamento esperado. Alterar os testes primeiro redefine formalmente o novo requisito da regra de negócio, para só depois alterarmos o código de produção de modo a satisfazer essa nova especificação.

## 5) Qual ciclo foi o mais difícil para você, e por quê?
O ciclo mais desafiador foi o Ciclo 7. Pois exigiu combinar regras lógicas complexas de negócio como encontrar a menor nota entre a A1 e a A2, validar os limites específicos da AI e garantir que a substituição condicional ocorresse corretamente sem afetar o resto dos componentes.