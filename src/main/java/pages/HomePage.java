package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @Step
    public AuthenticationPage signInButton(){
        $(".login").click();
        return new AuthenticationPage();
    }

}
