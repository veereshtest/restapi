package Utils;

import java.util.ArrayList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtils {
	//Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200 (Response res) {
        assertThat(res.getStatusCode(), is(equalTo(200)));
    }
    
    public void checkStatusIs404 (Response res) {
        assertThat(res.getStatusCode(), is(equalTo(404)));
    }
    
    public void checkStatusIs201 (Response res) {
        assertThat(res.getStatusCode(), is(equalTo(201)));
    }
    

    //Get Clients
    public ArrayList<?> getClients (JsonPath jp) {
        ArrayList<?> clientList = jp.get();
        return clientList;
    }
}
