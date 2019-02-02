package pages;

import com.codeborne.selenide.Condition;
import com.google.gson.Gson;
import helpers.ResourceLoader;
import io.qameta.allure.Step;
import pages.entity.PersonProfile;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CreateAnAccountPage extends CreateAccountPageLocators {

    private static PersonProfile getJsonData(String jsonFileName) {
        String pathToResourcesFolder = ResourceLoader.getResourceAsString(format("users/%s.json", jsonFileName));
        return new Gson().fromJson(pathToResourcesFolder, PersonProfile.class);
    }

    @Step
    public MyAccountPage fillInPersonalData(String registrationData) {
        PersonProfile json = getJsonData(registrationData);
        $(MRS_GENDER_RADIO_BOX).click();
        $(CUSTOMER_FIRSTNAME).setValue(json.getFirstName());
        $(CUSTOMER_LASTNAME).setValue(json.getLastName());
        $(CUSTOMER_PASSWD).setValue(json.getPassword());
        $(DAYS_OF_BITHDAY).selectOptionByValue(json.getBirthday().getDay());
        $(MONTHS_OF_BITHDAY).selectOptionByValue(json.getBirthday().getMonth());
        $(YEARS_OF_BITHDAY).selectOptionByValue(json.getBirthday().getYear());
        $(COMPANY_OF_BITHDAY).setValue(json.getCompany());
        $(ADDRESS_1).setValue(json.getAddress1());
        $(ADDRESS_2).setValue(json.getAddress2());
        $(CITY_FIELD).setValue(json.getCity());
        $(STATE_NAME_FIELD).selectOptionContainingText(json.getStateId());
        $(POSTCODE_FIELD).setValue(json.getPostcode());
        $(OTHER_FIELD).setValue(json.getOther());
        $(PHONE_FIELD).setValue(json.getPhone());
        $(PHONE_MOBILE_FIELD).setValue(json.getPhoneMobile());
        $(ALIAS).setValue(json.getAlias());
        $(SUBMIT_ACCOUNT_BUTTON).click();
        $(ACCOUNT_NAME).shouldHave(Condition.text(json.getFirstName() + " " + json.getLastName()));
        return new MyAccountPage();
    }

}
