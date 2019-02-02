package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;
import static pages.CreateAccountPageLocators.ACCOUNT_NAME;

public class MyAccountPage {

    private static final String HEADER_ACCOUNT = "h1";
    private static final By INFO_ACCOUNT_TEXT = By.className("info-account");
    private static final By LOGOUT = By.className("logout");
    private static final String PART_OF_URL_MY_ACCOUNT = "controller=my-account";
    private static final By WOMEN_CATEGORY_BOTTOM = By.linkText("Women");

    public MyAccountPage verifyFirstLastName(String firstLastName) {
        $(ACCOUNT_NAME).shouldHave(Condition.text(firstLastName));
        return this;
    }

    public MyAccountPage verificationForSuccessLogin() {
        $(HEADER_ACCOUNT).waitUntil(Condition.visible, 1000).shouldHave(Condition.text("MY ACCOUNT"));
        $(INFO_ACCOUNT_TEXT).shouldHave(Condition.text("Welcome to your account."));
        $(LOGOUT).shouldBe(Condition.visible);
        assertTrue(url().contains(PART_OF_URL_MY_ACCOUNT));
        return this;
    }

    public MyStorePage clickOnWomenCategoryBottom() {
        $(WOMEN_CATEGORY_BOTTOM).click();
        return new MyStorePage();
    }
}
