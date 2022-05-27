package StepDefenition;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import Base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static com.google.gson.JsonParser.*;


public class ServicesPathTestSteps extends TestBase{
	
	 RequestSpecification req;
	 Response r;
	
	@Before
	public void setUp()
	{
		TestBase.init();
	}
	
	@Given("I make a GET service with valid parameters Limit {int} and Skip {int}")
    public void i_make_a_get_service_with_valid_parameters_limit_and_skip(Integer limit, Integer skip) throws Throwable {
        req = RestAssured.given();
        r = req.baseUri(prop.getProperty("Base_URI_Bestbuy")).basePath(prop.getProperty("Base_Path_Bestbuy_services"))
        			.param("$limit", limit)
        			.param("$skip", skip)
        			.header("Accept","application/json")
        			.get();      
    }

    @Given("I make a POST service with Service {string} name")
    public void i_make_a_post_service_with_service_name(String service) throws Throwable {
    	 req = RestAssured.given();
    	 Map<String, Object> body = new LinkedHashMap<String, Object>();
    	 body.put("name",service);
    	 Gson gson = new Gson();
    	 String json = gson.toJson(body, LinkedHashMap.class);
    	 r = req.baseUri(prop.getProperty("Base_URI_Bestbuy")).basePath(prop.getProperty("Base_Path_Bestbuy_services"))
    			 .header("Accept","application/json")
    			 .header("Content-Type","application/json")
    			 .body(json)
    			 .post();
    }

    @Then("I verify response code is 200")
    public void i_verify_response_code_is_200() throws Throwable {
    	  Assert.assertEquals(r.getStatusCode(),200);  
    }

    @Then("I verify response code is 201")
    public void i_verify_response_code_is_201() throws Throwable {
  	  Assert.assertEquals(r.getStatusCode(),201);  
    }


}
