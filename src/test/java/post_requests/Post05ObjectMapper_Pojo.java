package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import util.ObjectMapperUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

    /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,                               // bu kimi pojo ile gondercez
            "title": "Tidy your room",
            "completed": false
          }


       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like  {
                               "userId": 55,
                               "title": "Tidy your room",        //karsidan gelen datayi yine pojo ya dondurup kullancaz
                               "completed": false,
                               "id": 201
                               }
     */

    //generic methodlar devreye giriyor test classında exception istemiyoruz bu yuzden baska bir class da exception ı try
    //catch ile handle edecegiz

    @Test  //en iyi yontem  objectmapper'i pojo calss'da kullanmak.
    public void post05() throws IOException {

        //set the url
        spec.pathParam("first","todos");

        //set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Odani Topla",false);
        //query paramatre

        //Send the request and get the response
        Response response = given().spec(spec).body(expectedData).post("{first}");
        response.prettyPrint();


        //Do Asserrtion
        //responsevalu 'yu okucak bu string olmali.ilki okunacak yer ikinicisi cevirelecek yer.
        //bir method olusturcaz o bizden bir string deger alicak ve onu herthagi bir data tipidir yani object olarak algilariz.
        //ve ona vecirecek.
        //jenerik method: <T> gibi birsey gorduk mesela.herhangi bir data turu alan donen anlaminda kullanilir.
        //asagidakimethod herhangi bir methoda ceviremey yariyor verdigimiz string degeri

        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }
}
