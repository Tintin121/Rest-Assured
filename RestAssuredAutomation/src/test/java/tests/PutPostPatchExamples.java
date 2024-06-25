package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import org.apache.commons.codec.binary.Base32;
import org.testng.annotations.Test;

public class PutPostPatchExamples {
	
	
	@Test
	public void TestCaePut_01() {
		
		baseURI="https://reqres.in/api";
		
		JSONObject req=new JSONObject();
		
		req.put("name", "tintin");
		req.put("job", "kill");
		
		given()
		.header("Content-Type","application/json")
		.body(req.toJSONString())
			.when().
		put("/users/2").
			then()
		.statusCode(200).
		log().
		all();
		}

	@Test
	public void patch_Example() {
		
		baseURI="https://reqres.in/api";
		
		JSONObject req=new JSONObject();
		req.put("name", "121");
		req.put("job", "qwq");
		
		given()
		.header("Content-Type","application/json")
		.body(req.toJSONString())
		.when()
		.patch("/users/2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void delete_Example() {
		
		baseURI="https://reqres.in/api";
		
		JSONObject req=new JSONObject();
		req.put("name", "121");
		req.put("job", "qwq");
		
		given()
		.header("Content-Type","application/json")
		.body(req.toJSONString())
		.when()
		.delete("/users/2")
		.then()
		.statusCode(204)
		.log().all();
		
	}
}
