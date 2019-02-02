package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import static helpers.ResourceLoader.loadPropertyName;

public class BaseApiClass {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        RestAssured.baseURI = loadPropertyName("API_BASE_URL");
    }

}
