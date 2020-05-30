package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import managers.FileReaderManager;

public class GetOperationExchangeRate {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private FileReaderManager fileReaderManager = FileReaderManager.getInstance();
//	private String url = fileReaderManager.getConfigReader().getBaseUrl();
	private URL url;
	
	public GetOperationExchangeRate() throws MalformedURLException {
		 url = new URL(fileReaderManager.getConfigReader().getBaseUrl());
	}
	

	
	@When("^I perform GET operation with valid Base \"([^\"]*)\" and Symbols \"([^\"]*)\"$")
	public void i_perform_GET_operation_with_valid_Base_and_Symbols(String arg1, String arg2) throws Throwable {
		
		RestAssured.useRelaxedHTTPSValidation("TLS");
		RestAssured.useRelaxedHTTPSValidation("SSL");
//		RestAssured.useRelaxedHTTPSValidation("SSLv2Hello");
		RestAssured.useRelaxedHTTPSValidation("SSLv3");
		RestAssured.useRelaxedHTTPSValidation("TLSv1");
		RestAssured.useRelaxedHTTPSValidation("TLSv1.1");
//		RestAssured.useRelaxedHTTPSValidation("TLSv1.3");
		response = RestAssured.get(fileReaderManager.getConfigReader().getBaseUrl());
		
		
	    
	}

	@Then("^I should get \"([^\"]*)\"$")
	public void i_should_get(String arg1) throws Throwable {
	    
		assertEquals(response.getStatusCode(), fileReaderManager.getConfigReader().getStatusCodeOK());
	}


	 
}
