package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
            2 id li ye put yapiyoruz
     */

    @Test
    public void get08(){
        //set the url
        spec.pathParams("first","todos","second",2);

        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        expectedData.put("id",2);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do a=Assertion
        Map<String,Object> actualData = response.as(HashMap.class); //DE-Serialization
        System.out.println("actualData = " + actualData);

        //2 mapi'i karsdilastirmak istedigi icin bu sekilde yaptik.

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),expectedData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));

        // And header "Via" is "1.1 vegur"
        assertEquals(expectedData.get("Via"),response.header("Via"));


        //            And header "Server" is "cloudflare"
        assertEquals(expectedData.get("Server"),response.header("Server"));



    }
}
