package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class TestGetandPost {

	@Test
	public void Test_01() {
		
		baseURI="https://reqres.in/api";
		
		given()
		.header("Content-Type","application/json")
		.get("/users?page=2")
		.then()
		.statusCode(200).
		body("data[0].first_name",equalTo("Michael"))
		.body("data.first_name",hasItems("Michael","George"));
			}
	
	@Test
	public void test_02() {
		
		JSONObject req=new JSONObject();
		req.put("name", "1Nitin");
		req.put("job", "req");
		
		baseURI="https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		.body(req.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201).log().all();
		
	}
}
