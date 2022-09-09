package Practice01;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class EX01 
{
@Test

public void test01()
{
	//RestAssured.baseURI="https://reqres.in/";
	
	Response responce = get("https://reqres.in/api/users?page=2");
	
	//System.out.println();
	System.out.println("body "+responce.getBody().asString());  
	System.out.println("status code - "+responce.getStatusCode());
	System.out.println("Responce time - "+responce.getTime());
	System.out.println("contain type - "+responce.getContentType());
		//https://github.com/rest-assured/rest-assured/wiki/Usage
}

@Test
public void test02()
{
	baseURI = "https://reqres.in/api";
	given().
	get("/users?page=2").
	then().statusCode(200).body("data[1].id",equalTo(8)).log().all();
	



}




}
