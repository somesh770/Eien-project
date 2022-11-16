package Practice02;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetMethod 
{	
	
 @Test
 public void getMethod1()
 {
	 baseURI= "https://reqres.in/api/";
		
	given().
	contentType(ContentType.JSON).
	when().
	get("users?page=2").
	then().statusCode(200).
	body("data[1].first_name",equalTo("Lindsay")).
	log().all();
		
 }
//---------------------------------------------------------------------- 
 @Test
 public void GetsingleUser()
 {
	 baseURI= "https://reqres.in/api/";
	 given().contentType(ContentType.JSON).
	 when().
	 get("users/2").
	 then()
	 .statusCode(200)
	 .body("data.first_name",equalTo("Janet")).log().all();
	 	

 }
//-------------------------------------------------------------------------- 
 
 @Test
 public void postMethod()
 {
	 JsonObject req = new JsonObject();
	 req.put("name", "morpheus");
	 req.put("job", "leader");
	 
	 baseURI = "https://reqres.in/api/";
	 
	  given()
	 .contentType(ContentType.JSON)
	 .body(req.toJSONString())
	 .when()
	 .post("users").then()
	 .statusCode(201)
	 .body("name", equalTo("morpheus"))
	 .body("job", equalTo("leader"))
	 .log().all();
	  	 
 }
 @Test
 public void putMethod()
 {
	 JSONPObject req = new JSONPObject();
	 req.put("name", "morpheus");
	 req.put("job", "zion resident");
	 
	 baseURI = "https://reqres.in/api/";
	 
	  given().auth().basic("username", "password")
	 .contentType(ContentType.JSON)
	 .body(req.toJSONString())
	 .when()
	 .put("users/2").then()
	 .statusCode(200)
	 .body("name", equalTo("morpheus"))
	 .body("job", equalTo("zion resident"))
	 .log().all();
 }
 
 
}

