package br.com.automation.pageobjects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import br.com.automation.Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Page {

	public static String operacao = null;
	public static Object[] arrElement;
	public static Map<String, Object> payLoadGeral = new HashMap<String, Object>();
	static String cenarioFixo;
	public static Response restAssuredResponse;
	public static String guardaRequest;
	public String jsonFinalTest;
	public static Map<String, Object> valorBody;
	io.restassured.specification.RequestSpecification requestspecs = given();
	public static String pegaResponse = null;
	public static int responseCode = -1;


	public void carregaAPI() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos/1";
		io.restassured.specification.RequestSpecification requestspecs = given();
		requestspecs.contentType("application/json");
	}
	
	public Response enviaGET(String cenario) {
		try {

			System.out.println("A URL utilizada será: " + RestAssured.baseURI);
			restAssuredResponse = requestspecs.get(RestAssured.baseURI);
			pegaResponse = restAssuredResponse.toString();
			System.out.println("Response retornado é: " + restAssuredResponse.asString());

			String jsonFinal = "";
			String metodo = "GET";

			Utils.printResponse(metodo, jsonFinal, cenario, restAssuredResponse.prettyPrint(), responseCode,
					restAssuredResponse.getTime());
			return restAssuredResponse;

		} catch (Exception e) {
			if (e.getMessage().contains("Não foi possivel realizar a conexão")) {
				Assert.fail("Provavelmente o serviço está fora do ar.");
				return null;
			} else {
				Assert.fail("Aconteceu um erro inesperado ao invocar este serviço. Response:"
						+ restAssuredResponse.asString());
				e.printStackTrace();
			}
		}
		return null;
	}
	



	public String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	public void validaResponse() {

		restAssuredResponse.then().assertThat().body("title", equalTo("delectus aut autem"));
	}
	
	public void validaResponseCode(int expectedHTTPResponseCode) {
		pegaResponse = restAssuredResponse.toString();
		System.out.println(pegaResponse);
		responseCode = restAssuredResponse.getStatusCode();
		if (responseCode != expectedHTTPResponseCode) {
			Assert.fail("StatusCode esperado : " + expectedHTTPResponseCode + " e o StatusCode recebido : "
					+ responseCode + " não são o mesmo. Response: " + restAssuredResponse.prettyPrint());
		}
		System.out.println(
				"StatusCode esperado : " + expectedHTTPResponseCode + " e o StatusCode recebido : " + responseCode);
	}

	public boolean validaTempoDeResposta(int timeLimit) {
		
		System.out.println("Tempo de resposta esperado : " + timeLimit + " e o Tempo de resposta recebido : "
				+ restAssuredResponse.getTime());
		if (restAssuredResponse.getTime() <= timeLimit) {
			return true;
		} else
			System.out.println("");
		return false;
	}

}
