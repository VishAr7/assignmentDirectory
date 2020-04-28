import static org.testng.Assert.assertEquals;

import java.lang.System.Logger;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ListenerFilePackage.ListenerImplementations;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

@Listeners(ListenerFilePackage.ListenerImplementations.class)

public class CustomerTests{
	
	static String url;
	static Response response;
	static String phoneNumber;
	static String accessToken;
	static String resBody;
	static int resCode;
	
	
	 @Test
	 public static void getAccessToken() {
		 
		url = "http://13.126.80.194:8080/authenticate";
		response = RestService.postMethod(url);
		resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200, "Response Code");
		
		accessToken = response.jsonPath().getString("token");
		
		System.out.println(accessToken);
	}
	
	 @Test (dependsOnMethods = {"getAccessToken"})
	 public static void getUsers() {
	 
		 url = "http://13.126.80.194:8080" + "/api/v1/users"; 
		 response = RestService.getMethod(accessToken, url); 
		 String userInfo = response.getBody().asString();
	  
		 resCode = response.getStatusCode(); 
		 Assert.assertEquals(resCode, 200, "Response Code");
	  
		 System.out.println(userInfo); 
	 }
	  
	  @Test(dependsOnMethods = {"getAccessToken"})
	  public static void getPhoneNumbers() {
	  
		  phoneNumber = "9972939567";
		 
		  url = "http://13.126.80.194:8080" + "/api/v1/users/" +phoneNumber;
		  response = RestService.getMethod(accessToken, url); 
		  String userInfo = response.getBody().asString();
		  
		  resCode = response.statusCode(); 
		  Assert.assertEquals(resCode, 200, "Response Code");
		  
		  System.out.println(userInfo); 
	  
	  }
	 

}
