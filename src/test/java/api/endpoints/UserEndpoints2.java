package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


/*
 * Created to perform 
 * CRUD operations
 * */


public class UserEndpoints2 {

	// method created for getting URLs from properties file
	static ResourceBundle getURL(){
		
		ResourceBundle routes=ResourceBundle.getBundle("routes"); // loads the properties file , looks for the file in test/resources folder.. no need to mention extension also
		return routes;
	
	}
	
	public static Response createUser(User payload){  // User payload is something yet to be implemented in POJO class
		
		String post_url=getURL().getString("post_url");
		Response response= given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return response;
	}
	
	public static Response getUser(String userName) {  // this userName we can get it from test case later
		
		String get_url= getURL().getString("get_url");
		Response response= given() 
				// we need to send only path param as part of get request
					.pathParam("username", userName) // this "username" is the variable name for path parameter and should match with get_url request /{username}
					
		.when()
			.get(get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){  // User payload is something yet to be implemented in test cases
		
		String put_url=getURL().getString("put_url");
		
		Response response= given()
				.pathParam("username", userName)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
			
		.when()
			.put(put_url);
		
		return response;
	}
	
	
	public static Response deletetUser(String userName) {  // this userName we can get it from test case later
		
		String delete_url=getURL().getString("delete_url");
		Response response= given() 
				// we need to send only path param as part of get request
					.pathParam("username", userName) // this "username" is the variable name for path parameter and should match with get_url request /{username}
					
		.when()
			.delete(delete_url);
		
		return response;
	}
	
	
}
