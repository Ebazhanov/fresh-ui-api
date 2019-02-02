package api;

import org.testng.annotations.DataProvider;

public class DataProviderStorage {

    @DataProvider(name = "countryValidation")
    public static Object[][] countryValidation() {
        return new Object[][]{
                {"United States of America", "US", "USA"},
                {"Germany", "DE", "DEU"},
                {"United Kingdom of Great Britain and Northern Ireland", "GB", "GBR"}
        };
    }
}
