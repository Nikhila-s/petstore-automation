package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


/*
 * Created to perform 
 * CRUD operations
 * */


public class UserEndpoints {

	
	public static Response createUser(User payload){  // User payload is something yet to be implemented in POJO class
		
		
		Response response= given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String userName) {  // this userName we can get it from test case later
		Response response= given() 
				// we need to send only path param as part of get request
					.pathParam("username", userName) // this "username" is the variable name for path parameter and should match with get_url request /{username}
					
		.when()
			.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){  // User payload is something yet to be implemented in test cases
		
		
		Response response= given()
				.pathParam("username", userName)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
			
		.when()
			.put(Routes.put_url);
		
		return response;
	}
	
	
	public static Response deletetUser(String userName) {  // this userName we can get it from test case later
		Response response= given() 
				// we need to send only path param as part of get request
					.pathParam("username", userName) // this "username" is the variable name for path parameter and should match with get_url request /{username}
					
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
	
}
