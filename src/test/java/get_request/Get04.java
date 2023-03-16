package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {




    /*
        Given
            https://jsonplaceholder.typicode.com/todos  ---get rwuest yaptik ilk once postman de icinde neler var baktik 200 adet json data varmis
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */


    @Test
    public void get04(){
        //belirlenen parametreler ile geliyor.
        //set the url
        //String url = " https://jsonplaceholder.typicode.com/todos";
        spec.pathParam("first","todos"); // first ola kisim baseUrl,todos kismi ise devami

        //set the expected data

        //send the request and get the response
        //asagida yazilan sekilde
        Response response =given().spec(spec).when().get("/{first}");// todos kisminin adi first oluyor.
        response.prettyPrint();

        //Do Assertion
        //body kismina id yazdik tum id leri getireceek
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).body("id",hasSize(200),//There should be 200 todos
                "title",hasItem("quis eius est sint explicabo"), ////"quis eius est sint explicabo" should be one of the todos title
                        "userIds",hasItems(2,7,9) // 2, 7, and 9 should be among the userIds
                        );




    }


    //hasSize() ==> eleman sayısını assert eder.
    //hasItem() ==> contains() methodu gibi objenin içerilip içerilmediğini assert eder.
    //hasItems() ==> containsAll() methodu gibi birden fazla objenin içerilip içerilmediğini assert eder.

    //spec icerisine baseUrl ekliyoruz.
}
