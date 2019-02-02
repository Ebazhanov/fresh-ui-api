package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyStorePage {

    private static final By PROCEED_TO_CHECKOUT_BUTTON_LAYER_CART = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");
    private static final By FIRST_ITEM = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    private static final By ADDED_TO_CARD_BUTTON = By.name("Submit");

    public MyStorePage clickOnFirstItem() {
        $(FIRST_ITEM).scrollTo().hover().waitUntil(Condition.exist, 3000).click();
        return this;
    }

    public MyStorePage clickOnAddToCardButton() {
        $(ADDED_TO_CARD_BUTTON).waitUntil(Condition.visible, 10000).click();
        return this;
    }

    public ShoppingCartsPage clickOnProceedToShoppingCartsPage() {
        $(PROCEED_TO_CHECKOUT_BUTTON_LAYER_CART).click();
        return new ShoppingCartsPage();
    }
}
