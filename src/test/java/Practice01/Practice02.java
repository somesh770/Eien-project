package Practice01;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Practice02 
{

	@Test
	public  void getMethod()
	
	{
		baseURI = "https://reqres.in/api";
		
		given().header("Content-type","Application/json").
		contentType(ContentType.JSON).
		get("/users?page=2").then().
		statusCode(200).
		log().all();
		
	}
//-----------------------------------------------------------------	
	
	
	
	
}
