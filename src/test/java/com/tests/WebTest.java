package com.tests;

import base.BaseUIClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;

@Feature("Main functionality")
public class WebTest extends BaseUIClass {

    private static final String JOE_BLACK = "Joe Black";
    private String existingUserEmail = "hf_challenge_123456@hf123456.com";
    private String existingUserPassword = "12345678";

    @Test
    @Story("Check registration of a new customer ")
    public void signInTest() {
        new HomePage()
                .signInButton()
                .enterRandomEmailInAccountBlock()
                .creatAnAccountButton()
                .fillInPersonalData("PersonalData")
                .verificationForSuccessLogin();
    }

    @Test
    @Story("Check login with existing Customer")
    public void logInTest() {
        new HomePage()
                .signInButton()
                .enterExistingEmail(existingUserEmail)
                .enterExistingPassword(existingUserPassword)
                .clickSignInButton()
                .verifyFirstLastName(JOE_BLACK)
                .verificationForSuccessLogin();
    }

    @Test
    @Story("Proceed to Order confirmation page")
    public void checkoutTest() {
        new HomePage()
                .signInButton()
                .enterExistingEmail(existingUserEmail)
                .enterExistingPassword(existingUserPassword)
                .clickSignInButton()
                .clickOnWomenCategoryBottom()
                .clickOnFirstItem()
                .clickOnAddToCardButton()
                .clickOnProceedToShoppingCartsPage()
                .registrateProduct()
                .clickOnConfirmOrderButton()
                .verifyOrderConfirmationDetails();
    }

}
