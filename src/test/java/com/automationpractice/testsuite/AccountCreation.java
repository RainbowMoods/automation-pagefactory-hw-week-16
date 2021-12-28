package com.automationpractice.testsuite;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreation extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void initialisation(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();
    }

    /**
     * Scenario Outline: verify that user should create account successfully
     * When I click on Sign in link
     * And I enter email for create account
     * And I click on create new account button
     * And I enter first name "<name>"
     * And I enter last name "<surname>"
     * And I enter register password "<password>"
     * And I enter address "<add>"
     * And I enter city "<city>"
     * And I select state "<state>"
     * And I enter postal code "<postal>"
     * And I select country "<country>"
     * And I enter phone number "<phone>"
     * And I click on register button
     */
    @Test
    @Parameters({"firstName", "lastName", "password", "address", "city", "state", "postal", "country", "phone"})
    public void verifyIfUserIsAbleToCreateAccountSuccessfully(String firstName, String lastName, String password,
                                                              String address, String city, String state, String postal,
                                                              String country, String phone) {
        new HomePage().clickOnSignInLink();
        new SignInPage().fillInEmailToCreateAccount();
        new SignInPage().clickOnCreateAccountButton();
        new CreateAccountPage().enterYourFirstName(firstName);
        new CreateAccountPage().enterYourLastName(lastName);
        new CreateAccountPage().enterYourPassword(password);
        new CreateAccountPage().enterYourAddress(address);
        new CreateAccountPage().enterYourCity(city);
        new CreateAccountPage().selectYourState(state);
        new CreateAccountPage().enterYourPostalCode(postal);
        new CreateAccountPage().selectYourCountry(country);
        new CreateAccountPage().selectYourState(state);
        new CreateAccountPage().enterYourPhoneNumber(phone);
        new CreateAccountPage().clickOnRegisterButton();
        new MyAccountPage().verifyAccountNameText(firstName);
    }

}
