package Practice01;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




public class Put_Patch_Delete 
{
	@Test
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
 
	@Test
	public void patchMethod()
	{	
		JSONObject request = new JSONObject();
		
		request.put("name", "umesh");
		request.put("job", "engineer");
		
		System.out.println(request);
		
		baseURI ="https://reqres.in";
		
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/api/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	@Test
	public void deleteMethod()
	{	
		JSONObject request = new JSONObject();
		
		request.put("name", "umesh");
		request.put("job", "engineer");
		
		System.out.println(request);
		
		baseURI ="https://reqres.in";
		
		when().delete("/api/users/2").
		then().
		statusCode(204).
		log().all();
	}
	
	
}
