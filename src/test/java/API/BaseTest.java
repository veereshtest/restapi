package API;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import Utils.TestUtils;
import utils.ApiUtils;

public class BaseTest {
	public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtils testUtils = new TestUtils();

    @BeforeClass
    public static void setup (){
        //Test Setup
        ApiUtils.setBaseURI(); //Setup Base URI
        ApiUtils.setBasePath("/api/");
        ApiUtils.setContentType(ContentType.JSON); //Setup Content Type
    }

    @AfterClass
    public static void afterTest (){
        //Reset Values
        ApiUtils.resetBaseURI();
        ApiUtils.resetBasePath();
    }

}
