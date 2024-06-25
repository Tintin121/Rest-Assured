package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

public class TestinLocal {

	
	@Test
	public void get() {
		
		baseURI="http://localhost:3000/";
		
		given().header("Content-Type","application/json")
		.get("/users")
		.then()
		.statusCode(200).body("FirstName[1]",equalToIgnoringCase("Sia"))
		.log()
		.all();

	}

	
	@Test
	public void post()
	{
		JSONObject req =new JSONObject();
		
		req.put("name", "Docker");
		//req.put("id", 3);
		
	baseURI="http://localhost:3000";
	
	given()
	.header("Content-Type","application/json")
	.body(req.toJSONString())
	.when()
	.post("/subjects")
	.then()
	.statusCode(201)
	.log()
	.all();
	
	
	
	
	}
	
	@Test
	public void post_user()
	{
		JSONObject req =new JSONObject();
		
		req.put("FirstName", "Prince");
		req.put("LastName", "Chauhan");
				
	baseURI="http://localhost:3000";
	
	given()
	.header("Content-Type","application/json")
	.body(req.toJSONString())
	.when()
	.post("/users")
	.then()
	.statusCode(201)
	.log()
	.all();
	
	}
	@Test
	public void Test_put()
	{
		JSONObject req =new JSONObject();
		
		req.put("FirstName", "Update");
		req.put("LastName", "Chauhan");
		req.put("subjectId", 3);		
	baseURI="http://localhost:3000";
	
	given()
	.header("Content-Type","application/json")
	.body(req.toJSONString())
	.when()
	.put("/users/4")
	.then()
	.statusCode(200)
	.log()
	.all();
	
	}
	
	@Test
	public void Test_patch()
	{
		JSONObject req =new JSONObject();	
		req.put("subjectId", 3);
				
	baseURI="http://localhost:3000";	
	given()
	.header("Content-Type","application/json")
	.body(req.toJSONString())
	.when()
	.patch("/users/4")
	.then()
	.statusCode(200)
	.log()
	.all();
	}
	
	
	@Test
	public void Test_delete()
	{				
	baseURI="http://localhost:3000";	
	given()
	.header("Content-Type","application/json")
	.when()
	.delete("/users/4")
	.then()
	.statusCode(200)
	.log()
	.all();
	}
}
