package api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryCode {

    private final String name;
    private final String alpha2Code;
    private final String alpha3Code;

    public CountryCode(
            @JsonProperty("name") String name,
            @JsonProperty("alpha2_code") String alpha2Code,
            @JsonProperty("alpha3_code") String alpha3Code) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }
}
