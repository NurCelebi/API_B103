package odev;

import base_urls.RegresUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Soru03 extends RegresUrl {

    /*
        Given
            https://reqres.in/api/users/2
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response format should be “application/json”
        And
            “email” is “janet.weaver@reqres.in”,
        And
            “first_name” is "Janet"
        And
            “last_name” is "Weaver"
        And
            "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
     */
    @Test
    public void soru03(){

        //set the url
        spec.pathParams("first","users","second",2);

        //set the expected data

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200).contentType(ContentType.JSON).body("email",equalTo("janet.weaver@reqres.in"),
       "first_name",equalTo("Janet"),"last_name",equalTo("Weaver"),"text",
                equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}