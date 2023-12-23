package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;



public class params_endpoints {
	
	public static Response createAPI(User data)
	{
		Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(data)
				.when()
				.post(BaseClass.create);
				
				return response;
	}

	
}
