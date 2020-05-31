package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import managers.FileReaderManager;

public class GetOperationExchangeRate {
	
	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;
	private FileReaderManager fileReaderManager = FileReaderManager.getInstance();
	

	
	@When("^I perform GET operation with Base and Symbols$")
	public void i_perform_GET_operation_with_valid_Base_and_Symbols(DataTable table) throws Throwable {
		//Table data passed from the feature steps
		List<List<String>> data = table.raw();
		
		//Getting the base URL for end-point 
		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();
		response = request.queryParam("base", data.get(1).get(0)).queryParam("symbols", data.get(1).get(1)).get("/latest");
	}

	@Then("^I should get response code as (\\d+)$")
	public void i_should_get(int statusCode) throws Throwable {
	    
		json = response.then().statusCode(statusCode);
		//Assertion for response code
		assertEquals(response.getStatusCode(), statusCode);
		
	}
	
	@And("^validate the following response$")
	public void validate_the_following_response(DataTable table) throws Throwable {
		
		List<List<String>> data = table.raw();

		String responseBody = response.body().asString();
		
		//Assertion for response data 
		assertEquals(responseBody.contains(data.get(1).get(0)), true);
		assertEquals(responseBody.contains(data.get(1).get(1)), true);

	}
	
	
	@Then("^validate the Content Type as \"([^\"]*)\"$")
	public void validate_the_Content_Type_as(String contentType) throws Throwable {
		//Assertion for Content type
	    assertEquals(response.contentType().contains(contentType), true);
	}
	
	
	@When("^I make an invalid request$")
	public void make_invalid_request() throws Throwable {
		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();
		//Making Invalid request
		response = request.get("/invalid");
	}
	
	
	@When("^I perform GET operation with Base, Symbols and Date$")
	public void i_perform_GET_operation_with_Base_Symbols_and_Date(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("id", data.get(1).get(0));
        
		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();
		// Making GET request with the passed data from the feature file
		response = request.queryParam("base", data.get(1).get(0)).queryParam("symbols", data.get(1).get(1)).get("/"+ data.get(1).get(2));
	}

	@When("^I make an invalid request with invalid date$")
	public void i_make_an_invalid_request_with_invalid_date() throws Throwable {
		
		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();
		
		//Making Invalid request with invalid date format
		response = request.get("/01-15-2020");//Invalid date format
	}

}
