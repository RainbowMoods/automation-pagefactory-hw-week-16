package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartButton;

    @FindBy(css = "a[title='Proceed to checkout'] span")
    WebElement proceedToCheckoutButton;

    public void clickOnAddToCartButton(){
        doClickOnElement(addToCartButton);
    }

    public void clickOnProceedToCheckoutButton(){
        doClickOnElement(proceedToCheckoutButton);
    }



}
