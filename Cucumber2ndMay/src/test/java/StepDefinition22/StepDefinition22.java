package StepDefinition22;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.http.HttpConnectTimeoutException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import EmployeePOJO.EmployeePOJO;
import Utilities.FetchDataFromProperty;
import Utilities.GetExcelValue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition22 {
	
	String URI=FetchDataFromProperty.ReadDataFromProperty().getProperty("base_uri");
	String token=FetchDataFromProperty.ReadDataFromProperty().getProperty("auth_token");
	String goRestURI=FetchDataFromProperty.ReadDataFromProperty().getProperty("gorestURI");
	String authtoken;
	RequestSpecification req,res;
	ResponseSpecification respec;
	Response response;
	
	
	
	
	
	@Given("user sends API request to create user to server")
	public void user_sends_api_request_to_create_user_to_server() {
	
		req=new RequestSpecBuilder().setBaseUri(URI).setContentType(ContentType.JSON)
				.build();
		
	   
	}

	@Given("user sends payload data along with request")
	public void user_sends_payload_data_along_with_request() throws JsonProcessingException {
		
	res=	given().log().all().headers("x-api-key","reqres_fb4fa31199e34db4816250165b1a52ff")
		.relaxedHTTPSValidation().spec(req).body(EmployeePOJO.EmployeeData());
		
	    
	}

	@When("user hits the server with {string} along with payload data")
	public void user_hits_the_server_with_along_with_payload_data(String endpoint) {
		
		respec= new ResponseSpecBuilder().build();
		response = res.when().post(endpoint).then().log().all().extract().response();
	   
	}

	@Then("validate user creation is done successfully with corresponding status code as {string}")
	public void validate_user_creation_is_done_successfully_with_corresponding_status_code_as(String status_code) throws Exception {
	   
		//int code=response.statusCode();
		Integer code=response.getStatusCode();
		String actual_code=code.toString();
		
		Assert.assertEquals(actual_code, status_code);
		
		long time=response.getTime();
		
		if(time>5000)
		{
			throw new Exception("Taking longer than expected");
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	@Given("user hits the go rest website")
	public void user_hits_the_go_rest_website() {
		
		req=new RequestSpecBuilder().setBaseUri(goRestURI).setContentType(ContentType.JSON)
				.build();

		System.out.println("Hello");
		
	  
	}

	@Given("user enters the auth token")
	public void user_enters_the_auth_token() {
		
		 authtoken=token;
				
	    
	}

	@Given("user send the credentails data")
	public void user_send_the_credentails_data() throws IOException {
		
		res=	given().log().all().headers("Authorization",authtoken)
				.relaxedHTTPSValidation().spec(req).body(GetExcelValue.getExcelValue());
		
	   
	}

	@When("user hits the go rest site with {string}")
	public void user_hits_the_go_rest_site_with(String endpoint) {
		
		respec= new ResponseSpecBuilder().build();
		response = res.when().post(endpoint).then().log().all().extract().response();
	    
	}

	@Then("verify that new user is created and validates {string}")
	public void verify_that_new_user_is_created_and_validates(String status_code) throws HttpConnectTimeoutException {
	 
		long time=response.getTime();
		if(time>5000)
		{
			throw new HttpConnectTimeoutException("More than expected time");
			
		}
		
		else
		{
			System.out.println("Within the threshold time");
		}
		
		Integer code=response.getStatusCode();
		String actual_code=code.toString();
		
		Assert.assertEquals(actual_code, status_code);
		
		
		
	}



}
