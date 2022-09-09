package Practice01;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPost 
{
	@Test
	public void getMethod()
	{
		baseURI ="https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Rachel"));
	}
	
	
// post method
	@Test(priority=1)
	public void postMethod()
	{
		//Map<String, Object>map = new HashMap<String, Object>();
		
//		map.put("name","morpheus");
//		map.put("job", "leader");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "somesh");
		request.put("job", "engineer");
		
		System.out.println(request);
		
		baseURI ="https://reqres.in/api";
		
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON).		
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	
	}
	
//---------------------------------------------------------------------
	@Test(priority=2)
	public void putMethod()
	{	
		JSONObject request = new JSONObject();
		
		request.put("name", "umesh");
		request.put("job", "engineer");
		
		System.out.println(request);
		
		baseURI ="https://reqres.in/api";
		
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
//-----------------------------------------------------------------	
	@Test(priority=3)
	public void get2()
	{
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
		Response responce  = get("https://reqres.in/api/users?page=2");
		
		System.out.println(responce.getBody().asString());
	}

}
