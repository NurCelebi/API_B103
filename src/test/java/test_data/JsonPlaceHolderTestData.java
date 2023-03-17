package test_data;

/*
        Map<String,Object> expectedData = new HashMap<>();//key ler icin string value lar icin object aldik.cunku datalar farkli o yuzden object olarak aldik
        expectedData.put("userId",21.0);
        expectedData.put("title","Wash The dishes");
        expectedData.put("completed",false);
 */

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId,String title,Boolean completed){

        Map<String,Object> expectedData = new HashMap<>();
        if (userId != null) { //eklemek istemedigim degerleri null atiyorum
            expectedData.put("userId", userId);
        }

        if (title!=null){
            expectedData.put("title", title);
        }

        if (completed!= null){
            expectedData.put("completed", completed);
        }


        return expectedData;
    }



}
