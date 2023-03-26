package odev;

import base_urls.RegresBaseUrl;
import pojos.RegresTestPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Soru07 extends RegresBaseUrl {

     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void soru07() {
        //Set the URl
        spec.pathParam("first", "users");
        //Set the expectedData
        RegresTestPojo expectedData = new RegresTestPojo("morpheus", "leader");
        System.out.println("ExpectedData" + expectedData);
        //Send the request and get the response
        Response response = given(spec).contentType(ContentType.JSON).accept(ContentType.JSON).body(expectedData).post("{first}");
        response.prettyPrint();
        //Do Assertion
        RegresTestPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), RegresTestPojo.class);
        System.out.println("ActualData" + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getJob(), actualData.getJob());
    }
}