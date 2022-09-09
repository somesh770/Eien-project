package Practice02;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetMethod 
{
 @Test
 public void getMethod1()
 {
	 baseURI = "https://reqres.in/api";
	 
	 given().
	 header("Content-type","Appliction/json").contentType(ContentType.JSON).
	 get("/users/23").then().statusCode(404).log().all();
	 
 }
 
//----------------------------------------------------------------
 @Test
 public void getMetohd2()
 {
	 baseURI ="https://reqres.in/api";
	 
	 given().header("content-type","Application/json").contentType(ContentType.JSON).
	 get("/unknown").then().statusCode(200).log().all();
 }
 
//----------------------------------------------------------------


}
