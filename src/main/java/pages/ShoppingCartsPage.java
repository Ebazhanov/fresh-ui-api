package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartsPage {

    private static final By PROCEED_TO_CHECKOUT_BUTTON_CART_NAVIGATION = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_PROCESS_ADDRESS = By.name("processAddress");
    private static final By AGREE_CHECKBOX = By.id("uniform-cgv");
    private static final By PROCEED_TO_CHECKOUT_PROCESS_CARRIER = By.name("processCarrier");
    private static final By PAY_BY_BANK_OPTION_BUTTON = By.className("bankwire");
    private static final By CONFIRM_MY_ORDER_BUTTON = By.xpath("//*[@id='cart_navigation']/button");
    
    public ShoppingCartsPage registrateProduct() {
        $(PROCEED_TO_CHECKOUT_BUTTON_CART_NAVIGATION).click();
        $(PROCEED_TO_CHECKOUT_BUTTON_PROCESS_ADDRESS).click();
        $(AGREE_CHECKBOX).click();
        $(PROCEED_TO_CHECKOUT_PROCESS_CARRIER).click();
        $(PAY_BY_BANK_OPTION_BUTTON).click();
        return this;
    }

    public OrderConfirmationPage clickOnConfirmOrderButton() {
        $(CONFIRM_MY_ORDER_BUTTON).click();
        return new OrderConfirmationPage();
    }
}
