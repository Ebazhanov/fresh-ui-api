package base;


import com.codeborne.selenide.Selenide;
import helpers.ScreenshotOnFailure;
import org.testng.annotations.*;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.BrowserSelection.selectBrowser;
import static helpers.ResourceLoader.loadPropertyName;

@Listeners(ScreenshotOnFailure.class)
public class BaseUIClass {

    private static String baseUrl;

    @Parameters({"env", "browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(@Optional("test") String env, @Optional("chrome") String browser) {
        selectBrowser(browser);
        clearBrowserCache();
        switch (env) {
            case "test":
                baseUrl = loadPropertyName("UI_BASE_URL");
                break;
            case "prod":
                baseUrl = loadPropertyName("PROD_UI_BASE_URL");
                break;
        }
        Selenide.open(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    void after() {
        clearBrowserCache();
        closeWebDriver();
    }

}
