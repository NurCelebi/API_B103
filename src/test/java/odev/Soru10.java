package odev;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Soru10  extends AutomationExerciseBaseUrl {

    /*2)
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/

    @Test
    public void soru10() {
        //set the url
        spec.pathParam("first","productsList");
        Response response = given(spec).get("{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion
        JsonPath jsonPath = response.jsonPath();
        int kadinKullaniciList = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        System.out.println("kadinKullaniciList = " + kadinKullaniciList);
        assertEquals(12,kadinKullaniciList);


    }

}
