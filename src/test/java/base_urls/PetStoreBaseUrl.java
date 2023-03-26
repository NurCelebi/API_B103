package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStoreBaseUrl {

    protected RequestSpecification spec;


    @Before //her test methodundan once calisir
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/").build();

    }
}
