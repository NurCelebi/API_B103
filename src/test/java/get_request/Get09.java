package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {

    /*
      Given
          https://restful-booker.herokuapp.com/booking/2279
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */
    @Test
    public void get09(){
        //set the url
        spec.pathParams("first","booking","second",5491);

        //set the xepected data--ilk once icteki mao'i olusturcaz.
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checking","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData = new HashMap<>(); // herseyi kapsayan buyuk Map.
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap);
        expectedData.put("additionalneeds","Dinner");

        //send the rquest and get the response
        Response response =given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("firstname"));
        assertEquals(expectedData.get("firstname"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));

        //Json datamizda checkin checkout kismi Map olacak bir kisim .bunu assert ederken asagidaki gib yapmamiz lazim.
        //actualData.get("bookingdates")-- obje .ve biz bjeyi Map'e ceviri assert edicez.
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }

    @Test //dinamik yontem
    public void get09b(){
        //set the url
        spec.pathParams("first","booking","second",5491);

        //set the xepected data--ilk once icteki mao'i olusturcaz.
        HerOkuAppTestData obj1 = new HerOkuAppTestData();

        Map<String,String> bookingdatesMap = obj1.bookingdatesMapMethod("2018-01-01","2019-01-01");

        Map<String,Object> expectedData = obj1.expectedDataMethod("John","Smith",111,true,bookingdatesMap ,"Dinner");
//                new HashMap<>(); // herseyi kapsayan buyuk Map.
//        expectedData.put("firstname","John");
//        expectedData.put("lastname","Smith");
//        expectedData.put("totalprice",111);
//        expectedData.put("depositpaid",true);
//        expectedData.put("bookingdates",bookingdatesMap);
//        expectedData.put("additionalneeds","Breakfast");

        //send the rquest and get the response
        Response response =given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("firstname"));
        assertEquals(expectedData.get("firstname"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));

        //Json datamizda checkin checkout kismi Map olacak bir kisim .bunu assert ederken asagidaki gib yapmamiz lazim.
        //actualData.get("bookingdates")-- obje .ve biz bjeyi Map'e ceviri assert edicez.
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }


}
