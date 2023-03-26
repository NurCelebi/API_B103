package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExerciseBaseUrl {

    protected RequestSpecification spec;


    @Before //her test methodundan once calisir
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();

    }
}