# Test Cases

#### Task #1 - Refactoring UI tests

##### @STEPS ("Check registration of a new customer)
    public void signInTest() 
                .clickOnLoginButton()
                .enterRandomEmailInAccountBlock()
                .creatAnAccountButton()
                .fillInPersonalData("PersonalData")
                .verificationForSuccessLogin();
    
##### @STEPS ("Check login with existing Customer")
    public void logInTest() 
                .clickOnLoginButton()
                .enterExistingEmail(existingUserEmail)
                .enterExistingPassword(existingUserPassword)
                .clickSignInButton()
                .verifyFirstLastName(JOE_BLACK)
                .verificationForSuccessLogin();
    
##### @STEPS ("Proceed to Order confirmation page")
    public void checkoutTest() {
                .clickOnLoginButton()
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
   
#### Task 2 - API tests

##### @TEST #1
```Get all countries and validate that US, DE and GB were returned in the response```
##### @TEST #2 
```Get each country (US, DE and GB) individually and validate the response```
##### @TEST #3
```Get information for inexistent countries and validate the response```
##### @TEST #4
```Add new Country by using POST request```


