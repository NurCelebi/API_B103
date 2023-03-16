package odev;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Soru04 extends HerOkuAppBaseUrl {

      /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */
        @Test
        public void soru04(){

            //Set the URL
            spec.
            pathParam("first","booking").
            queryParams("firstname","Almedin",
                    "lastname","Alikadic");

            //Set the expected data

            //Send the request and get the response
            Response response = given().spec(spec).when().get("/{first}");
            response.prettyPrint();

            //Do assertion
            response.then().statusCode(200);

            //Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
            assertTrue(response.asString().contains("bookingid"));




    }

}
