package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static junit.framework.Assert.assertTrue;

public class OrderConfirmationPage {

    public static final String GREEN_COLOR = "rgba(119, 119, 119, 1";

    public OrderConfirmationPage verifyOrderConfirmationDetails() {
        $("h1").waitUntil(Condition.visible, 1000).shouldHave(Condition.text("ORDER CONFIRMATION"));
        $(By.xpath("//li[@class='step_done step_done_last four']")).shouldBe(Condition.visible);
        $(By.xpath("//li[@id='step_end' and @class='step_current last']")).shouldBe(Condition.visible);
        $(By.xpath("//*[@class='cheque-indent']/strong")).shouldHave(Condition.text("Your order on My Store is complete."));
        assertTrue(url().contains("controller=order-confirmation"));
        $("#step_end").getCssValue("color").contains(GREEN_COLOR);
        return this;
    }
}
