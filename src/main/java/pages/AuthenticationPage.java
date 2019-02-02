package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class AuthenticationPage {

    private String getRandomEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

    @Step
    public AuthenticationPage enterRandomEmailInAccountBlock() {
        $(By.id("email_create")).setValue(getRandomEmail());
        return this;
    }

    @Step
    public CreateAnAccountPage creatAnAccountButton() {
        $(By.id("SubmitCreate")).click();
        return new CreateAnAccountPage();
    }

    @Step
    public AuthenticationPage enterExistingEmail(String existingUserEmail) {
        $(By.id("email")).setValue(existingUserEmail);
        return this;
    }

    @Step
    public AuthenticationPage enterExistingPassword(String existingUserPassword) {
        $(By.id("passwd")).setValue(existingUserPassword);
        return this;
    }

    @Step
    public MyAccountPage clickSignInButton() {
        $(By.id("SubmitLogin")).click();
        return new MyAccountPage();
    }

}
