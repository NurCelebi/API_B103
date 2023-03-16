package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Get03 {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be “application/json”
      And
          “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
      And
          “completed” is false
      And
          “userId” is 2
     */

    @Test
    public void get03() {
        //set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint(); //ekrana yazdirdik

        //Do Assertion
        //1. Yol: istenilen seylerin olup olmadigina bakicaz.Body ile ilgili assertion yapabilirim.
        // Body metoduna json datanin key value degerlerini yazarsam mesela title derim equalTo ile karsiliigini
        // yazip karsdilastiririm.daha sonra path'i karsilastiriyorum yine equalTo ile.
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).//“title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
                body("completed", equalTo(false)).//"completed": false
                body("userId", equalTo(2));//"userId": 2


        //2. Yol:ama bu body ile ayri ayri yaptigimi tek bir body icerisinde de soft assertion olarak yapabilirim.
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));
        //Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz. Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
        //Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çaılışmayı durdurur.


        /*
   Api üzerinde Body içerisinde yer almayan değerler için herhangi bir ekstra methoda gerek duymadan assert yapılırken,
   Body içerisinde yer alan değerler için body() methodu ile birlikte Matchers kullanılarak assert yapılır.
*/

    }

}