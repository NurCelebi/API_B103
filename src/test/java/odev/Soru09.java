package odev;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Soru09 extends PetStoreBaseUrl {

    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sens Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */

    @Test
    public void soru09(){
        //set the url
        spec.pathParams("first","pet","second","findByStatus").queryParam("status","available");

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        int availablePetSayisi = response.jsonPath().getList("id").size();
        assertTrue(availablePetSayisi>100);

    }
}
