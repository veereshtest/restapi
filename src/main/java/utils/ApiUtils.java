package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class ApiUtils {
	    //Global Setup Variables
	    public static String path;
	    public static String jsonPathTerm;

	    //Sets Base URI
	    public static void setBaseURI (){
	        RestAssured.baseURI = "https://reqres.in/";
	    }

	    //Sets base path
	    public static void setBasePath(String basePathTerm){
	        RestAssured.basePath = basePathTerm;
	    }

	    //Reset Base URI (after test)
	    public static void resetBaseURI (){
	        RestAssured.baseURI = null;
	    }

	    //Reset base path
	    public static void resetBasePath(){
	        RestAssured.basePath = null;
	    }
	    
	  //Sets ContentType
	    public static void setContentType (ContentType Type){

        }
	    
	  //Returns response by given path
	    public static Response get(String url, ContentType contentType) {
	        Response res = 
	        		given().
	        		when().
	        		contentType(contentType).
	        		get(url);
	        return res;
	    }
	    
	    //Post Request by Path
	    public static Response post(String url) {
	        Response res = 
	        		 when().
	        		 post(url);
	        return res;
	    }
	    
	    //Returns JsonPath object
	    public static JsonPath getJsonPath (Response res) {
	        String json = res.asString();
	        //System.out.print("returned json: " + json +"\n");
	        return new JsonPath(json);
	        
	        
	        
	    }

	}

