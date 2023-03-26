package odev;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Soru06 extends RegresBaseUrl {

     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */


    @Test
    public void soru06(){

        //set the url
        spec.pathParam("first","unknown");

        //send the request get the response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        //Do assertion

        //1)Status code is 200
            assertEquals(200,response.statusCode());

        //2)Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> name = json.getList("data.pantone_value");
        System.out.println("name = " + name);

        //3)Print all ids greater than 3 on the console
                //(3'ten büyük id'leri yazdırınız)
        List<Integer> idList = json.getList("data.findAll{it.id>3}.id");
        System.out.println("idList = " + idList);
        assertEquals(3,idList.size());

        //4)Print all names whose ids are less than 3 on the console
        //              (id'si 3'ten küçük isimleri yazdırınız)
        List<Integer> idList1 = json.getList("data.findAll{it.id<3}.name");
        System.out.println("idList1 = " + idList1);

        //Assert that the number of names whose ids are less than 3 is 2
        //              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
        assertEquals(2,idList1.size());


    }




}
