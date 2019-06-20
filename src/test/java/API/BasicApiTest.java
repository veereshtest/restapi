package API;

import org.junit.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import utils.ApiUtils;
import static org.hamcrest.Matchers.equalTo;

public class BasicApiTest extends BaseTest {
	
	@Test
    public void tstVerify200Response1(){
      res = ApiUtils.get("users?page=2", ContentType.JSON );
      testUtils.checkStatusIs200(res) ; 
      
	}
	
	@Test
    public void tstVerify200Response2(){
      res = ApiUtils.get("users/2", ContentType.JSON );
      testUtils.checkStatusIs200(res);
      
	}
	
	@Test
    public void tstVerify404Response1(){
      res = ApiUtils.get("users/23", ContentType.JSON );
      testUtils.checkStatusIs404(res);
      
	}
	
	@Test
    public void tstVerify200Response3(){
      res = ApiUtils.get("unknown", ContentType.JSON );
      testUtils.checkStatusIs200(res);
      
	}
	
	@Test
    public void tstVerify200Response4(){
      res = ApiUtils.get("unknown/2", ContentType.JSON );
      testUtils.checkStatusIs200(res);
}
	
	@Test
    public void tstVerify404Response2(){
      res = ApiUtils.get("unknown/23", ContentType.JSON );
      testUtils.checkStatusIs404(res);
      
	}
	
	@Test
    public void tstVerify201ResponseonPOST1(){
		String myJson = "{\"name\":\"morpheus\", \"job\":\"test\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  post("users").
          then().
          assertThat().statusCode(201);
		  
           }
	
	@Test
    public void tstVerify200ResponseonPUT(){
		String myJson = "{\"name\":\"morpheus\", \"job\":\"zion resident\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  put("users/2").
          then().
          assertThat().statusCode(200).
          body("job", equalTo("zion resident"));
		
	       }
	
	@Test
    public void tstVerify204ResponseonDELETE(){
		String myJson = "{\"name\":\"morpheus\", \"job\":\"zion resident\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  delete("users/2").
          then().
          assertThat().statusCode(204);
		
	       }
	
	@Test
    public void tstVerify201ResponseonPOST2(){
		String myJson = "{\"email\":\"eve.holt@reqres.in\", \"password\":\"pistol\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  post("register").
          then().
          assertThat().statusCode(200).
		  body("token", equalTo("QpwL5tke4Pnpja7X4"));
		  
           }
	
	@Test
    public void tstVerify400ResponseonPOST(){
		String myJson = "{\"email\":\"sydney@fife\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  post("register").
          then().
          assertThat().statusCode(400);
		  
           }
	
	@Test
    public void tstVerify400ResponseonPOST2(){
		String myJson = "{\"email\":\"peter@klaven\"}";
		  given().
		  body(myJson).
		  contentType("application/json").
		  when().
		  post("login").
          then().
          assertThat().statusCode(400);
		 
           }
	
	@Test
    public void tstVerifyDelayResponse(){
		 given().
		  when().
		  get("users?delay=3").
         then().
         assertThat().statusCode(200).
		 body("data[0].first_name", equalTo("George"));
		  
          }
}

