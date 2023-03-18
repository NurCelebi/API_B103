package test_data;

import java.util.HashMap;
import java.util.Map;

/*
 Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checking","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData = new HashMap<>(); // herseyi kapsayan buyuk Map.
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap);
        expectedData.put("additionalneeds","Breakfast");
 */
public class HerOkuAppTestData {
    public Map<String,String> bookingdatesMapMethod(String checkin,String checkout){ //burada her iki deger de string di
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);
        return bookingdatesMap;

    }

    public Map<String, Object> expectedDataMethod(String firstname,String lastname, Integer totalprice, Boolean depositpaid, Map<String, String>  bookingdatesMap, String additionalneeds ){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname",firstname);
        expectedData.put("lastname",lastname);
        expectedData.put("totalprice",totalprice);
        expectedData.put("depositpaid",depositpaid);
        expectedData.put("bookingdates",bookingdatesMap);
        if (additionalneeds!=null){
            expectedData.put("additionalneeds",additionalneeds);
        }


        return expectedData;
    }



}
