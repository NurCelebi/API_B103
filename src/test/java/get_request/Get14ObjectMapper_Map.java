package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Map extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo" , //bunu direkyt olustran methodumuz var oradan cagirip yapiyoruz
									    "completed": true
									  }
     */
    //

    @Test
    public void get14(){

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
        //test data var oradan alipmap'e cevirebilirim
        //object mapper ile  cevirilmesini istedigimiz Json datayi string'e cevirim sonunu hasmap deyince map'e dondurmus oluyor.

//        String json = " {\n" +
//                "\t\t\t\t\t\t\t\t\t    \"userId\": 10,\n" +
//                "\t\t\t\t\t\t\t\t\t    \"id\": 198,\n" +
//                "\t\t\t\t\t\t\t\t\t    \"title\": \"quis eius est sint explicabo\" ,  \n" +   //BU GORUNTUDEN KURTULMAK ICIN SIMDIDDE YENI BIR  METHOD YAPICAZ.expected datayi string yapan bir method yapicaz istersen icine istemedigini koyma
//                "\t\t\t\t\t\t\t\t\t    \"completed\": true\n" +
//                "\t\t\t\t\t\t\t\t\t  }";


        //ben json'i string'e cevirdim aagidaki method ile o da string olan kodu Map'e cevirdi.

        String json = JsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);
        Map<String,Object> expectedData = ObjectMapperUtils.convertJsonToJava(json, HashMap.class);      //json'i javaya ceviren meythod
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response --body get request de kullaniolmiyor
        Response response = given().spec(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));



    }
}
