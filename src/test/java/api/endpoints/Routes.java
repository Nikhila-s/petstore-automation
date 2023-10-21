package api.endpoints;



/*Swagger.io::
 * create user  : POST https://petstore.swagger.io/v2/user
 * get user : GET https://petstore.swagger.io/v2/user/{username}
 * update user : PUT https://petstore.swagger.io/v2/user/{username}
 * update user : DELETE https://petstore.swagger.io/v2/user/{username}

 * */
public class Routes {
	
	// maintain only the urls
	
	public static String Base_url="https://petstore.swagger.io/v2";
	
	// User module urls:
	public static String post_url= Base_url+"/user";
	public static String get_url= Base_url+"/user/{username}";
	public static String put_url= Base_url+"/user/{username}";
	public static String delete_url= Base_url+"/user/{username}";
	
	// Store module urls
	
	// Pet module urls
}
