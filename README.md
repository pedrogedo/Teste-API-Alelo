# Automação de Teste de API

Este projeto tem como objetivo realizar a consulta no endpoint: [https://jsonplaceholder.typicode.com/todos/1](https://jsonplaceholder.typicode.com/todos/1), através de um Teste Automatizado utilizando **Java**, **RestAssured**, **Cucumber**, validando a mensagem retornada no response.


## Pré Requisitos

- Ter o Eclipse instalado na máquina, caso não tenha acesso, clique [aqui](https://www.eclipse.org/downloads/) para realizar o download.

- Ter o Google Chrome na versão **81.0.4044.138**.

- Ter o **Cucumber** instalado no **Eclipse**. Para realizar a instalação você deve ir no eclipse em **Help > Eclipse Marketplace**, procurar por cucumber e realizar a sua instalação.

## Para executar o software

- Após ter baixado ou clonado o projeto e extraído em sua máquina, importe o projeto no **Eclipse** usando o **Import Existing Maven Projects**.  

- Expandir no seguinte caminho: **testeAPI > src/test/java > br.com.automation.functionalities** e executar a classe **Runner** clicando com o lado direito do mouse em cima dela e com o lado esquerdo na opção **Run As > JUnit Test**. Com isso o teste será executado e será possível enxergar no console o resultado obtido na execução do software.

- Outra maneira interessante de executar o teste é pela feature. Para isso acesse o seguinte caminho: **testeAPI > src/test/java > br.com.automation.functionalities** e executar a feature clicando com o lado direito do mouse em **cenario.feature** e **Run As > Cucumber Feature**. Com isso o teste será executado e será possível enxergar no console o resultado obtido.

- Na pasta **TestResults** será possível visualizar os logs de execução, quando executamos o software pela classe **Runner**.
