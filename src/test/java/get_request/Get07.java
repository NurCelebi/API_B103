package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07 extends JsonPlaceHolderBaseUrl {
    /*
        Given
              https://jsonplaceholder.typicode.com/todos/ -- endpoint request yapicaz ve test edicez
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk olanlari id sini oldugunu dogrulayin
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */
    @Test
    public void get07(){

        //set the url
        spec.pathParam("first","todos");

        //set the expected data

        //Send the request and get the response
        Response response =given().spec(spec).get("/{first}");
        response.prettyPrint();

        //DO ASSERTION
        assertEquals(200,response.statusCode());//status code is 200

        //Print all ids greater than 190 on the console
        JsonPath jsonPath = response.jsonPath();
        List<Integer> list= jsonPath.getList("findAll{it.id>190}.id"); //190dan buyuk olanlari filtrelemek icin kullandigimiz yontem --Groovy Language Java temelli bir programlama dilidir.
        System.out.println("list = " + list);  //list halinde tum id'leri yazdirir

        /*
        json datayi sinirlandirma yapmak icin groovy language ile yazip istenileni cagirabilriz.
        id'si 190dan buyuk olanlari yazdir diyor
        jsonPath yaptim list'e attim ve getList olarak getirdim 190dan buyuk olanlari alacagim icin ise
        Groovy language yazarak "findAll{it.id>190}.userId alabilirim
        mesela 200'u alacaksam "findAll{it.id==200}.userId yaparim
         */
       // Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk olanlari id sini oldugunu dogrulayin
        assertEquals(10,list.size());

       // Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       List<Integer> userIdList =jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("list = " + userIdList);

        //Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        assertEquals(4,userIdList.size());

        //Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);


        //            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
        //            basliginin "delectus aut autem" icerdigini dogrulayin
        assertEquals("title uyusmadi",titleList.contains("delectus aut autemX"));
    }


}
