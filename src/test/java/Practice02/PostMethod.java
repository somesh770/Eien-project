package Practice02;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class PostMethod 
{
@Test
public void postMethod()
{
	baseURI="https://reqres.in/api";
	
	JSONObject req = new JSONObject();
	
	req.put("name", "morpheus");
	req.put("job", "leader");
	
	Response postresponce =  given()
	.header("content-type","Application/json")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.auth().none().body(req.toJSONString())
	.when()
	.post("/users");
	
	System.out.println(postresponce.getTime());
	
	//.then().statusCode(201).log().all();
	
	
}
}
