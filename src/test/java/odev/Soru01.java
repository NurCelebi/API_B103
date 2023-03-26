package odev;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Soru01 extends RegresBaseUrl {

      /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void soru01(){

        //set the url
        spec.pathParams("first","users","second","3");

        //set the expected data

        //send the request and get the response
        Response response=given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");



    }
  //***************** baska turlu cozum*********
    //  @Test
    //    public  void get01(){
    //
    //        //Set the URL
    //        String url = "https://reqres.in/api/users/3";
    //
    //        //Set The Expected Data
    //
    //        //Send The Request and Get The Response
    //        Response response = given().when().get(url);
    //        response.prettyPrint();
    //
    //
    //        //Do Assertion
    //
    ////        HTTP Status Code should be 200
    ////        Content Type should be JSON
    ////        Status Line should be HTTP/1.1 200 OK
    //        response.
    //                then().
    //                statusCode(200).
    //                contentType(ContentType.JSON).
    //                statusLine("HTTP/1.1 200 OK");
    //    }
    //}
}
