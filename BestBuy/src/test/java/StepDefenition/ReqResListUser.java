package StepDefenition;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;

import Base.TestBase;
import TestData.Data;
import TestData.UserPOJO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqResListUser extends TestBase{

	
	RequestSpecification req = RestAssured.given();
	Response res;

	@Before
	public void setUp()
	{
		TestBase.init();
	}
	
	@Given("I make a GET user with valid parameters page")
	public void i_make_a_get_user_with_valid_parameters_page(DataTable page) throws Throwable {

		UserPOJO userPojo;

		List<Data> lidata;
		List<Data> liDataOdd;

		res = req.given().baseUri(prop.getProperty("Base_URI_ReqRes")).basePath(prop.getProperty("Base_Path_ReqRes_Users"))
				.queryParam("page", page.cell(0, 0))
				.when()
				.get();

		System.out.println(res.getBody().asPrettyString());

		userPojo = res.getBody().as(UserPOJO.class);

		System.out.println(userPojo.toString());

		lidata = userPojo.getData();
		int len = lidata.size() - 1;
		for (int i = 0; i <= len; i++) {
			int tempId = lidata.get(i).getId();
			if (tempId % 2 != 0) {
				System.out.println(tempId);
			}
		}
	}

	 @Then("I verify response code is 200 for reqres") 
	 public void i_verify_response_code_is_200_for_reqres() throws Throwable {
	 Assert.assertEquals(res.getStatusCode(), 200); 
	 }
}
