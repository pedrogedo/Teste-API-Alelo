package br.com.automation.steps;

import static org.junit.Assert.assertTrue;

import br.com.automation.pageobjects.Page;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class Steps {

	private Page telaInicialPage = new Page();
	public String cenarioCucumber = "";
	public static int responseCode = -1;

	@Before
	public void beforeHook(Scenario scenario) throws Exception {
		addScenario(scenario.getName());
	}

	public void addScenario(String scenario) throws Exception {
		System.out.println(scenario);
		cenarioCucumber = scenario.toString();
	}

	@Given("carrego a URL de Consulta")
	public void carregar_URL() {
		telaInicialPage.carregaAPI();
	}

	@When("envio o comando GET")
	public void envia_GET() throws InterruptedException {
		telaInicialPage.enviaGET(cenarioCucumber);
	}

	@Then("lista apresentada com sucesso")
	public void validarGET() throws InterruptedException {
		telaInicialPage.validaResponse();
	}
	
	@Then("^o status de retorno é (\\d+) e o tempo de resposta é menor ou igual a (\\d+) milisegundos$")
	public void o_status_code_é_tempo_resposta(int statusCode, int timeLimit) throws Throwable {
		telaInicialPage.validaResponseCode(statusCode);
		assertTrue(telaInicialPage.validaTempoDeResposta(timeLimit));
	}
}