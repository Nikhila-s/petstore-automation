package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	// we need to create 4 tests - CRUD
	// we need data to send
	Faker faker;
	User userPayload;
	public Logger logger;
	
	
	@BeforeClass
	public void setupData() {
		
		 faker =new Faker();
		 userPayload=new User();
		 
		 
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setUsername(faker.name().fullName());
		 userPayload.setEmail(faker.internet().emailAddress());
		 userPayload.setFirstname(faker.name().firstName());
		 userPayload.setLastName(faker.name().lastName());
		 userPayload.setPassword(faker.internet().password());
		 userPayload.setPhone(faker.phoneNumber().phoneNumber());
		 userPayload.setUserStatus(0);
		 
		 
		 // logs
		 logger=LogManager.getLogger(this.getClass());
		 
		 
		 
	}
	
	@Test(priority=1)
	public void test_postUser() {
		
		logger.info("Creating user***");
		Response response=UserEndpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("User is created***");
		String username=response.jsonPath().get("username");
		// System.out.println(username);
		logger.info("Created username is "+username);
	
	}
	
	
	@Test(priority=2)
	public void test_getUserByName() {
	Response response=	UserEndpoints2.getUser(this.userPayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);

		
	}
		
    @Test(priority=3)
    public void test_updateUserByname() {
    	userPayload.setPassword(faker.internet().password());  // this regenerates the pwd
	Response response=UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
	 
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	// validating data after updating
	Response res=UserEndpoints2.getUser(this.userPayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(res.getStatusCode(), 200);
	
}
    
    
    
    @Test(priority=4)
    public void test_deleteUser() {
    	
    	Response response= UserEndpoints2.deletetUser(this.userPayload.getUsername());
    	response.then().log().all();
    	Assert.assertEquals(response.getStatusCode(), 200);
    }
    

}
