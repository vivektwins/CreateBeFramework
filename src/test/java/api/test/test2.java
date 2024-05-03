package api.test;

import org.bson.assertions.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class test2 {

	 @BeforeAll
	    public static void setup() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	    }

	    @Test
	    public void getRequest() {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/posts")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
	    }
	    
	    String requestBody = "{\n" +
	            "  \"title\": \"foo\",\n" +
	            "  \"body\": \"bar\",\n" +
	            "  \"userId\": \"1\" \n}";
	    
	    @Test
	    public void postRequest() {
	        Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(requestBody)
	                .when()
	                .post("/posts")
	                .then()
	                .extract().response();

	        Assert.assertEquals(201, response.statusCode());
	        Assert.assertEquals("foo", response.jsonPath().getString("title"));
	        Assert.assertEquals("bar", response.jsonPath().getString("body"));
	        Assert.assertEquals("1", response.jsonPath().getString("userId"));
	        Assert.assertEquals("101", response.jsonPath().getString("id"));
	    }
	}


