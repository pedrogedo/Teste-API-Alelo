@testeExemploAPI
Feature: Automação do endpoint de Consulta por ID

  ############################################################################################
  #																						LISTAR POR ID 																 #
  ############################################################################################
  @Listar @geral
  Scenario: Listar por ID
    Given carrego a URL de Consulta
    When envio o comando GET
    Then lista apresentada com sucesso
    And o status de retorno é 200 e o tempo de resposta é menor ou igual a 3000 milisegundos
