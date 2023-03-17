package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {
    
    //bu siteye karsilik bir islem yapacak olursak buradan extend edip cagiracagiz.


    protected RequestSpecification spec;
    //bumetot calismazsa null olur.her testen once calistirmak istersem burayi @before koymam gerekir.
    //extend yapanlar protectedlara exten yaparak ulasabilir baska package'lerden.


    //setUp before ile calsiir.spec 'e atama yaptik
    //spec icinde base url var ve diger onemli seyler var.
    //artik herseyi spec metodu ile cagirabilecegim.belirtilen parametreler ile gelecek
    @Before //her test methodundan once calisir
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();



    }
}
