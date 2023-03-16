package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
      /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    //TestNg ile hic isimiz yok sadece sofAssert yaparken ihtiyacim oluyor. Islerimiz JUnit ile yapacagiz hep.
    //body kismi Json dilinde oldugu icin ve biz burada calistigimiz icin u kodu Java dili ile yazmamiz gerekiyor.

    @Test //JUnit'den test kullandik.
    public void post01() {
        //Set the URL
        spec.pathParam("first", "todos"); //bir tane param old icin 'param' dedik

        //Set the expected data ==> Payload // bizim gonderecegimiz data.karsi tarafa gondercez.Java dilinde yaziyoruz Json'i API kullaniyor.o yuzdeen java dili ile yaziyoruz burada.
        //key-value degerleri old icin map icinde yaptik isimizi
        // key'ler string , value'lar int string boolean old icin biz onlari topluca 'object' olarak yaziyoruz.
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55.0);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        //'Cannot serialize because no JSONor XML serializer found un classpath.' uyarisi goruyoruz.Bu JSON yada XML 'i cevirici birsey yok diyor
        // .bu yuzden biz kodumuza ContentType(ContentType.JSON) koymamiz gerekiyor.
        //yani bu yazdigimiz kodu JSON'a ceviremiyor bu yuzden koyduk.
        //pom.xml'e JSON ekledik.kodumuzu JSON kodunua cevirebilsin diye library ekledik.
        //bir de 'gson' var.Map'i JSON'a cevirdi.java objesini Json oobjesi olarak API'ye gonderdik bu sekilde.yani library ekeldik.
        Response response = given().spec(spec).contentType(ContentType.JSON).when().body(expectedData).post("/{first}");
        response.prettyPrint();

        //Do Assertion--expected ve actual karsilastirmasi yaparak asser islemi yapicaz
        //response-> json tipindeydi ben bunu java'ya cevircem once bunun icin response.as(HashMap.class) yaptim.
        Map<String, Object> actualData = response.as(HashMap.class);//DE-Serialization ==> Json -> Java
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));//farkli dillerde karsilastirma yparken bu sekilde yapiyoruz.
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));

        /*
        De-Serialization: Json datanin Java objesine cevrilmesidir.
        Serialization: Java objesini Json dataya  cevrilmesidir.
        2 turlu De-Serialization islemi yapacagiz: Bunlar ;
          1) Gson:Google tarafindan uretilmistir
          2)Object Mapper: daha cok tercih edilen daha cok kullanilan bir library'dir.
          --datayi guncelleme islemi put request ile yapilir yani post yerine put yapabiliriz.bunu dokumantasyondan anliyoruz.
         */
    }
}