package StepDefenition;

import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Base.TestBase;
import TestData.Categories;
import TestData.Data;
import TestData.DataProductsPOJO;
import TestData.ProductsPOJO;
import TestData.ResponseBodyGetProductsPOJO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductPathTestSteps extends TestBase {
	
	 RequestSpecification req = RestAssured.given();
	 Response res;
	 ResponseBodyGetProductsPOJO  responseBodyGetProductsPOJO;
	
	@Before
	public void setUp()
	{
		TestBase.init();
	}
	
	@Given("I make a POST request with valid product {string} name")
    public void i_make_a_post_request_with_valid_product_name(String product) throws Throwable {
       
		ObjectMapper objMapper = new ObjectMapper();
		
		objMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		ProductsPOJO productObject = new ProductsPOJO(product,"fruit",10,5,"upc","description","manufacturer","model","url","image");
		
		String myRequestPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productObject);
		
		System.out.println(myRequestPayload.toString());
	
		res = req.baseUri(prop.getProperty("Base_URI_Bestbuy")).basePath(prop.getProperty("Base_Path_Bestbuy_products"))
				.header("Content-Type","application/json" ).header("Accept","application/json")
				.body(myRequestPayload)
				.post();	
    }

    @Then("verify response code 201")
    public void verify_response_code_201() throws Throwable {
    	Assert.assertEquals(res.getStatusCode(),201);
    }
    
    @Then("verify response code is 200")
    public void verify_response_code_200() throws Throwable {
    	Assert.assertEquals(res.getStatusCode(),200);
    }
    
    
    @Given("I make a GET product with valid parameters Limit {int} and Skip {int}")
    public void i_make_a_get_product_with_valid_parameters_limit_and_skip(int limit, int skip) throws Throwable {
    	
        res = req.baseUri(prop.getProperty("Base_URI_Bestbuy")).basePath(prop.getProperty("Base_Path_Bestbuy_products"))
        			.param("$limit", limit)
        			.param("$skip", skip)
        			.header("Accept","application/json")
        			.when().get(); 
        
         responseBodyGetProductsPOJO = RestAssured.given().baseUri(prop.getProperty("Base_URI_Bestbuy")).basePath(prop.getProperty("Base_Path_Bestbuy_products"))
		.param("$limit", limit)
		.param("$skip", skip)
		.header("Accept","application/json")
		.when().get().as(ResponseBodyGetProductsPOJO.class);
        
        System.out.println(responseBodyGetProductsPOJO.toString());
    }
    
    @Then("I verify the first id is 346575")
    public void i_verify_the_first_id_is_346575() throws Throwable {
   
    	List<DataProductsPOJO>  dataPOJO= responseBodyGetProductsPOJO.getdataproductsPOJO();
    	int idFromResponse =  dataPOJO.get(0).getId();
    	System.out.println(idFromResponse);
    	
    	
    }
        
}
