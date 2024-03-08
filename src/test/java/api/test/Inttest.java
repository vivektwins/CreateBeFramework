package api.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.testng.Assert;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Inttest extends Thread{

	static String host= "https://reqres.in/";
	int count =0;	
	public void run()
	{
		//100 user
		        
		       Random r = new Random();
		
				UUID randomUUID = UUID.randomUUID();
				
				
				for(int i=0;i<100;i++)		{
					
					String name= randomUUID.toString().replace("-", "")+r.nextInt(200);

					String input = "{\n"
						+ "    \"name\": \""+name+"\",\n"
						+ "    \"job\": \"leader\"\n"
						+ "}";
				
				
				Response response3 = given().contentType(ContentType.JSON).and().body(input).when().post(host+"api/users").then()
						.extract().response();
				System.out.println(response3.asPrettyString());
				System.out.println(input);
				System.out.println(Thread.currentThread().getId());
				count++;
				
				}
				System.out.println("Thread count - "+ count);
	}
	
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		
		Inttest in = new Inttest();
		Thread t = new Thread(in);
		t.start();
		Thread t2 = new Thread(in);
		t2.start();
		Thread t3 = new Thread(in);
		t3.start();
		Thread t4 = new Thread(in);
		t4.start();
		Thread t5 = new Thread(in);
		t5.start();
		Thread t6 = new Thread(in);
		t6.start();
		
		//GET
//		Response response= given().contentType(ContentType.JSON).when().get(host+"api/users?page=2").then()
//				.extract().response();
//		System.out.println(response.asPrettyString());
//		String response_value = response.asPrettyString();
//		Assert.assertEquals(response.getStatusCode(),200);
//		JSONObject js = new JSONObject(response_value);
//		JSONArray jas = new JSONArray(js.getString("data"));
//		System.out.println(jas);
//		
//		
//				
//		
//				
//		//POST
//		String body = "{\n"
//				+ "    \"name\": \"morpheus\",\n"
//				+ "    \"job\": \"leader\"\n"
//				+ "}";
//		Response response1= given().contentType(ContentType.JSON).body(body).when().post(host+"api/users").then()
//				.extract().response();
//		System.out.println(response1.asPrettyString());
//		System.out.println(response1.getHeader("Content-Type") + "-------");
//		System.out.println(response1.getTime());
//
//		System.out.println(response1.headers());
////		
//		for(Header r: response1.headers())
//		{
//			
//			System.out.println(r.getName() + "and - " + r.getValue());
//		}
//		Assert.assertEquals(response1.getStatusCode(),201);
//		Assert.assertEquals(response1.jsonPath().getString("name"),"morpheus");
//		System.out.println(response1.jsonPath().getString("name"));
//
//		
		
	}

}
