package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1)Postman manuel API testi icin kullanilir.
    2) API otomasyonu icin Rest Assured Library kullanacagiz.
    3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
       --> Gereksinimleri anlama
       --> Test case'i yazma:
           -Test case'i yazamka icin :Gherkin Language" kullaniyoruz.
           x)Given: on kosullar--> Endpoint,body
           y)When: Islemler --> Get,Put,Delete.....
           z)Then: Donutler --> Assert
           t)And: Coklu islemlerin art arda yazilacagi yerlerde kullanilir
       --> Test kodunu yazarken su adimlari izleriz:
           i)Set the URL
           ii) Set the expected data(gelen data)
           iii) Send the reques and get the response(request gonder response al)
           iv) Do assertion

     */

    public static void main(String[] args) {
        //daha dfinamik hale getirmek icin bir container icine url mizi koyduk.
        String url ="https://restful-booker.herokuapp.com/booking/55";
        //Get request nasil yapilir:
        Response response = given().when().get(url);
        //prettyPrint() metodu response datayi yazdirir.
        response.prettyPrint();

        //Status Code nasil yazdirilir?
        //statusCode int deger olarak gelir ve o skeilde yazdirabiliriz
        System.out.println("statusCode() = " + response.statusCode()); //statusCode() = 200

        //Content Type nasil yazdirirlir?
        System.out.println("contentType() = " + response.contentType()); //contentType() = application/json; charset=utf-8

        //status lIne nasil yazdirilir?
        System.out.println("statusLine() = " + response.statusLine()); //statusLine() = HTTP/1.1 200 OK

        //Header nasil yazdirilir
        System.out.println("header(\"Connection\") = " + response.header("Connection"));
        System.out.println(response.header("Server")); //header("Connection") = keep-alive

        //Headers nasil yazdirilri
        System.out.println(response.headers());
        //Cowboy
//        Server=Cowboy
//        Connection=keep-alive
//        X-Powered-By=Express
//        Content-Type=application/json; charset=utf-8
//        Content-Length=174
//        Etag=W/"ae-X5WQX6zkiLMWMUwQWoEPIAsJqqM"
//        Date=Sat, 11 Mar 2023 20:15:49 GMT
//        Via=1.1 vegur
        System.out.println(response.getHeaders());

        //time nasil yazdirilir.
        System.out.println("Time :" +response.getTime()); //Time :2943


    }
}
