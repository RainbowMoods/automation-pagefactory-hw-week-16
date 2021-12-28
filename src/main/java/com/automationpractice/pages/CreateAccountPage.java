package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(css = "#customer_firstname")
    WebElement firstNameLocator;
    @CacheLookup
    @FindBy(css = "#customer_lastname")
    WebElement lastNameLocator;
    @CacheLookup
    @FindBy(css = "#passwd")
    WebElement passwordLocator;
    @CacheLookup
    @FindBy(css = "#address1")
    WebElement addressLocator;
    @CacheLookup
    @FindBy(css = "#city")
    WebElement cityLocator;
    @CacheLookup
    @FindBy(xpath = "//select[@id='id_state']")   //dropdown
    WebElement stateLocator;
    @CacheLookup
    @FindBy(css = "#postcode")
    WebElement postcodeLocator;
    @CacheLookup
    @FindBy(css = "#id_country")    //dropdown
    WebElement countryLocator;
    @CacheLookup
    @FindBy(css = "#phone_mobile")
    WebElement phoneNumberLocator;
    @CacheLookup
    @FindBy(css = "button[id='submitAccount'] span")
    WebElement registerButtonLocator;
    @CacheLookup
    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement createAccountText;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='My account']")
    WebElement myAccountTextHeading;

    public void enterYourFirstName(String name) {

        doSendTextToElement(firstNameLocator, name);
        Reporter.log("Entering First Name : '" + name + "'"+"<br>");
    }

    public void enterYourLastName(String surname) {
        doSendTextToElement(lastNameLocator, surname);
        Reporter.log("Entering Last Name: '" + surname + "'"+"<br>");
    }

    public void enterYourPassword(String pass) {

        doSendTextToElement(passwordLocator, pass);
        Reporter.log("Entering Password : '" + pass + "'"+"<br>");
    }

    public void enterYourAddress(String add) {

        doSendTextToElement(addressLocator, add);
        Reporter.log("Entering address : '" + add + "'"+"<br>");
    }

    public void enterYourCity(String city) {
        doSendTextToElement(cityLocator, city);
        Reporter.log("Entering city: '" + city + "'"+"<br>");
    }

    public void selectYourState(String st) {
        doSelectByValueFromDropDown(stateLocator, st);
        Reporter.log("Entering State: '" + st + "'"+"<br>");
    }

    public void enterYourPhoneNumber(String phone) {
        doSendTextToElement(phoneNumberLocator, phone);
        Reporter.log("Entering Phone number: '" + phone + "'"+"<br>");
    }

    public void enterYourPostalCode(String postal) {
        doSendTextToElement(postcodeLocator, postal);
        Reporter.log("Entering postcode: '" + postal + "'"+"<br>");
    }

    public void selectYourCountry(String country) {
        doSelectByValueFromDropDown(countryLocator, country);
        Reporter.log("Entering Country: '" + country + "'"+"<br>");
    }

    public void clickOnRegisterButton() {
        doClickOnElement(registerButtonLocator);
        Reporter.log("click on register button"+"<br>");
    }
}
