package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									    "id": 198
									   }
     */
    //biz burada 198 id li bir data vardi ama biz o datayi baska biilgiler ile degistirdik.maqnuel olarak degistirdigimiz seyi assert ederek burada kontrol eettik


    @Test
    public void pu01(){

        //set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected data -- degistirecegimiz datayi bu bolume giriyoruz
        Map<String,Object> expectedData = new HashMap<>();//key ler icin string value lar icin object aldik.cunku datalar farkli o yuzden object olarak aldik
        expectedData.put("userId",21.0);
        expectedData.put("title","Wash The dishes");
        expectedData.put("completed",false);

        System.out.println("expectedData = " + expectedData);

        //her seferinde put yapmamiz tekrarlama oluyor.tekrardan kacinmak icin daha dinamik hale getirmemiz gerekir.
        // Reusable Method olusturup her assertion da kullancaz.bunun icin method olusturcaz.package acicaz.expected data metodumuzu olusturcaz orada.
        //simdi method atayarak yapicaz put bolumunu.


        //Send the request and get the response //when yapacagimiz action'dan once kullaniliuor ama simdi gerek yok.
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//Json da Java ya ceviriyoruz as metodu ile
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
      //id=198'i assert etmiyorum cunku ben zaten 198i updat ediyorum.
        //Junit kullanma sesbimiz daha eski daha stabil old icin.



    }

    @Test //dinamik yontem
    public void put1b(){

            //set the url
            spec.pathParams("first","todos","second",198);

            //Set the expected data -- degistirecegimiz datayi bu bolume giriyoruz
            JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData(); //baska package dan ulasmak icin olusturduk bu objeyi
            Map<String,Object> expectedData = obj.expectedDataMethod(21,"Wash the dishes",false);
            System.out.println("expectedData = " + expectedData);

            //actualData = {completed=false, id=198, title=Wash the dishes, userId=21}-- console da cikan sonuc

            //her seferinde put yapmamiz tekrarlama oluyor.tekrardan kacinmak icin daha dinamik hale getirmemiz gerekir.
            // Reusable Method olusturup her assertion da kullancaz.bunun icin method olusturcaz.package acicaz.expected data metodumuzu olusturcaz orada.
            //simdi method atayarak yapicaz put bolumunu.


            //Send the request and get the response //when yapacagimiz action'dan once kullaniliuor ama simdi gerek yok.
            Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
            response.prettyPrint();

            //Do Assertion
            Map<String, Object> actualData = response.as(HashMap.class);//Json da Java ya ceviriyoruz as metodu ile
            System.out.println("actualData = " + actualData);

            assertEquals(200,response.statusCode());
            assertEquals(expectedData.get("completed"),actualData.get("completed"));
            assertEquals(expectedData.get("userId"),actualData.get("userId"));
            assertEquals(expectedData.get("title"),actualData.get("title"));
            //id=198'i assert etmiyorum cunku ben zaten 198i updat ediyorum.
            //Junit kullanma sesbimiz daha eski daha stabil old icin.


        }

        //id'yi ceviriren 21.0 geliyordu bunu daha iyi cevirsin diye pom.xml'e ekledik.daha saglikli de-serialization yapmak icin.
        /*
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.1</version>
           </dependency>
         */
}
