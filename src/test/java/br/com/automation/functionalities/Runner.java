package br.com.automation.functionalities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.automation.Utils.Utils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/br/com/automation/features/cenario.feature", glue = { "" }, tags = {
		"@Listar" }, monochrome = true, dryRun = false)
public class Runner {

	@BeforeClass
	public static void beforeClass() throws Exception {
		String reportName = "";
		System.out.println(">> Iniciando a execução dos testes...");
		reportName = "report_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		Utils.fileTestResult = "./TestResults/" + reportName + "/";
		new File(Utils.fileTestResult).mkdir();

	}

	@AfterClass
	public static void afterClass() {
		
		System.out.println(">> Finalizando a execução dos testes...");
	}
}
