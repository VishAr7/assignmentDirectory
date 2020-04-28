import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection.*;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import fileUtilities.IOUtils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;


 public class RestService {
	
	static RequestSpecification http = RestAssured.given();
	
	public static Response postMethod(String url){
	
		RestAssured.baseURI = "http://13.126.80.194:8080";
		http.header("Content-Type", "application/json");
		
		/*
		 * JSONObject authenticate = new JSONObject(); authenticate.put("username",
		 * "rupeek"); authenticate.put("password", "password");
		 * 
		 * http.body(authenticate.toJSONString()); JSONObject authenticate = new
		 * JSONObject(); authenticate = IOUtils.readFiles();
		 */
		
		try {
			http.body(IOUtils.readFiles().toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Response response = http.post(url);
		
		return response;
	}
	

	public static Response getMethod(String token, String url) {
		
		http.header("Authorization", "Bearer "+token);
		
		RestAssured.baseURI = "http://13.126.80.194:8080";
		Response response = http.get(url);
		return response;
	}
}





