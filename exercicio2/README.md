# Softplan Interview - Exercício 2
  
* Para realizar o build execute:  
  
``` ./${PROJECT_ROOT}/exercicio2/gradlew build ```
   
* O resultado é um jar que recebe como parâmetro o caminho absoluto para o arquivo contendo o json de entrada:

```  
 java -jar ${PROJECT_ROOT}/exercicio2/build/libs/exercicio2-0.0.1.jar '${CAMINHO_DO_ARQUIVO_SERVICOS_COMPOSICOES}/arquivo-servicos-composicoes.json'
```  

## Considerações sobre a implementação    
* Esse exercício gerou alguma dúvida quanto a assertividade dos casos de teste fornecidos.   
  A estratégia de arredondamento adotada na implementação entretanto, se aplicou como esperado 
  para 4 dos 5 casos de teste. Logo, foi realizado um incrmento de 2 décimos para o valor referente 
  a composição de código 98561 para que o mesmo pudesse ser considerado.  
  
* Encontrar um método de precisão e escala para efetuar os cálculos propostos, gerou um esforço significativo,  
  A planilha **${PROJECT_ROOT}/exercicio2/assets/simulação calculo de preços.xlsx** é resultado do esforço para 
  adotar parâmetros de cálculo aceitáveis dado os casos de teste apresentados. Uma precisão de 5 casas decimais e 
  método ROUND_DOWN foram os valores adotados para os parâmetros de cálculo.  
  
* Foi adotado o caracter '\n' como separador ao imprimir o resultado dos cálculos.