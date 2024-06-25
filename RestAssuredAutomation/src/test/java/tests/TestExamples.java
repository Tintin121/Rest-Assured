package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void Test_1() {
		
		Response res= get("https://reqres.in/api/users?page=2"); 
		
		//Resassured.get we are using but now we have made the restassured library static and because of this 
		//we can call the the get method directly
		
		res.getStatusCode();
		res.getTime();
		System.out.println(res.statusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asPrettyString());
		
		
		int statuscode=res.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void Test_2() {
		
		
		baseURI="https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200).
		body("data[0].email",equalToIgnoringCase("michael.lawson@reqres.in"))
		.log()
		.headers();
		}
	
	@Test
	public void test_03() {
		
		baseURI="https://reqres.in";
		
		given().
		get("/api/users/2").
		then().
		statusCode(200).log().all();
		
		//body("data.id",equalTo(2))
		//.body("data.id", hasItems(2));
		;
	}
	}
	
	


