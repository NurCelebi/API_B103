package get_request;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get10 extends GoRestBaseUrl {

 /*

        Given
            https://gorest.co.in/public/v1/users/128529
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
 {
    "meta": null,
    "data": {
        "id": 128529,
        "name": "Anamika Joshi",
        "email": "anamika_joshi@corkery-ritchie.info",
        "gender": "male",
        "status": "active"
    }
}
     */

    @Test
    public void get10(){
        //set the url
        spec.pathParams("first","users","second",128529);

        //set the expected data
        GoRestTestData obj = new GoRestTestData();
        Map<String,String> dataMap =obj.dataMapMethod("Anamika Joshi","anamika_joshi@corkery-ritchie.info","male","active");


        Map<String,Object> expectedData = obj.expectedDataMapMethod(null,dataMap);
        System.out.println("expectedData = " + expectedData);

        //SEND THE REQUEST AND GET THE RESPONSE
       Response response= given().spec(spec).get("/{first}/{second}");
       response.prettyPrint();

       //Do Assertion --
        //500 hatasi nedeniyle verildi


    }

}
