# Softplan Interview - Exercício 1  
  * Para realizar o build execute:    
    
``` ./${PROJECT_ROOT}/exercicio1/gradlew build ```  
  * O resultado dos testes pode ser analisado acessando a página:  
  
```    
 file://${PROJECT_ROOT}/exercicio1/build/libs/reports/tests/test/index.html  
```   
## Considerações sobre a implementação de código legado(aspectos negativos)  
 * encoding do arquivo não é UTF-8  
 * NullpointerExcetion não tratado na linha 21  
 ``` ... if (!lista.isEmpty()) ... ``` 
 * Uso de interface List sem explicitar o tipo   
 * Falta de padrão na organização de código  
 * As mensagens de resultado poderiam ser definidas em uma resource-bundle ou estrutura específica
 * No template referente ao total, falta informar o símbolo de reais já que as ocorrências o renderizam  
   
 ``` 
  5 cujo valor é R$ 0,30. Total = 1.550,30.  
 ```
 * O atrituto **texto** poderia ser omitido, além de não ter a visibilidade adequada
 * A forma como o prefixo para mensagem é definida deve ser melhorada
 * O StringBuilder(linha 39) está subutlizado

## Pontos relevantes da refatoração efetuada
* Aplicação do conceito de **Formatadores** ao definir as mensagens para singular/plural
* Generalização do parâmetro de entrada, bem como do retorno de forma que seja possível gerar dados para por exemplo alimentar uma api de relatórios como Jasperreport, etc...
* Aplicação de resource-bundle para definição das mensagens
* Uso de locale para tratar os formatar informação sobre moeda