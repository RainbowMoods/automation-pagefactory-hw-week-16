package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage extends Utility {

    public SignInPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAddressToCreateAccount;


    public void fillInEmailToCreateAccount() {
        String randomString = getRandomString(5);
        String email= "www."+randomString+"@gmail.com";
        doSendTextToElement(emailAddressToCreateAccount, email);
        Reporter.log("fill in email: '" + email + "'"+"<br>");
    }

    public void clickOnCreateAccountButton(){
        doClickOnElement(createAccountButton);
    }


}
