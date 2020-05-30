package runners;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.restassured.RestAssured;


@CucumberOptions(
 features = "src/test/resources/features", glue = {"stepDefinitions"}, tags = {"@LatestExchange, @HistoricalExchange"}
//		 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	@BeforeSuite
	public void setup() {
		System.out.println("Inside-----------------------------------------Before Suite");
		RestAssured.useRelaxedHTTPSValidation("TLS");
		RestAssured.useRelaxedHTTPSValidation("SSL");
//		RestAssured.useRelaxedHTTPSValidation("SSLv2Hello");
		RestAssured.useRelaxedHTTPSValidation("SSLv3");
		RestAssured.useRelaxedHTTPSValidation("TLSv1");
		RestAssured.useRelaxedHTTPSValidation("TLSv1.1");
		RestAssured.useRelaxedHTTPSValidation("TLSv1.2");
	}

}
