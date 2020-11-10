# Desafio-GTarquimedes
Desafio parar criar um WebService REST utilizando Java/Spring Boot e shell script, onde:

1- O WebService deve fornecer uma URL que permita o envio de dois parâmetros (nome do arquivo, conteúdo do arquivo) Exemplo: /api/nome/conteudo;

2- Ao acessar esse recurso via browser o WebService deverá executar um arquivo shell script que deverá ser implementado da seguinte forma:

2.1- O shell script receberá os dois parâmetros (nome do arquivo, conteúdo do arquivo);

2.2- O shell script criará um arquivo utilizando esses dois parâmetros;

2.3- O shell script exibirá uma mensagem dizendo que o arquivo com o nome (nome do arquivo) foi criado com sucesso;

2.4- O WebService deve receber a mensagem exibida pelo shell script e retornar para o usuário;

Exemplo: http://localhost:8080/api/v1/desafio/teste/texto

![Sem título](https://user-images.githubusercontent.com/52057635/98685857-a81ba900-2346-11eb-8efa-bb42b33ce9b8.png)
