package odev;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Soru11 extends HerOkuAppBaseUrl {

     /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                  {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
                (TestNG Soft assertion yapınız)
     */

    @Test
    public void getRequest(){
        //Set the Url
        spec.pathParams("first","booking","second",22);

        //Set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Guoqiang","Morante Briones",111,true,bookingDatesPojo,"Breakfast");

        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);



        //Soft Assertion
        //1. Adım: SoftAssert Objesi Oluştur
        SoftAssert softAssert = new SoftAssert();

        //2. Adım: Assertion Yap
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Firstname uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastname uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"totalprice uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"depositpaid uyusmadi");
        softAssert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds(),"additionalneeds uyusmadi");

        softAssert.assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin(), "checkin uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout(), "checkout uyusmadi");

        //3. Adım: assertAll() methodunu kullan
        softAssert.assertAll();


        //Hard Assertion
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());


    }

}
