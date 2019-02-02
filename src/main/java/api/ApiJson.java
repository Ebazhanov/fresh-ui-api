package api;

import api.schema.CountryCode;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;

import java.util.List;


public class ApiJson {

    private static final String RESULT_JSON_PATH = "RestResponse.result";

    private final JsonPath jsonPath;

    private ApiJson(String json) {
        this.jsonPath = JsonPath.from(json);
    }

    public static ApiJson from(String json) {
        return new ApiJson(json);
    }

    /**
     * @return get result for one country
     */
    @Step
    public CountryCode getCountryCode() {
        return jsonPath.getObject(RESULT_JSON_PATH, CountryCode.class);
    }

    /**
     * @return get result for multiple countries in one response
     */
    @Step
    public List<CountryCode> getAllCountriesCodes() {
        return jsonPath.getList(RESULT_JSON_PATH, CountryCode.class);
    }

}
