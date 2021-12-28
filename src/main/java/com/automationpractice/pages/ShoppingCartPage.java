package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCartPage extends Utility {

    public ShoppingCartPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Your shopping cart is empty.')]")
    WebElement messageEmptyCart;

    @FindBy(xpath = "//span[@id='summary_products_quantity']")
    WebElement numberOfProductsText;

    @FindBy(xpath = "//td[@class='cart_delete text-center']//a")
    WebElement deleteButton;

    By deleteButton1 = By.xpath("//td[@class='cart_delete text-center']//i[@class='icon-trash']");

    public void verifyNumberOfProducts(){
        String expected = "1 Product";
        String actual = numberOfProductsText.getText().trim();
        Assert.assertEquals(actual,expected,"Number of product text did not match");
    }

    public void verifyDeleteButtonIsAvailable(){
        boolean isButtonDisplayed=false;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        if(wait.until(ExpectedConditions.attributeContains(deleteButton,"title", "Delete"))){
            isButtonDisplayed=true;
        }
        Assert.assertTrue(isButtonDisplayed,"Delete button not displayed");
    }

    public void clickOnDeleteButton(){
        doClickOnElement(deleteButton);
    }

    public void verifyMessageOfShoppingCartIsEmpty(String expectedMessage){
        String actual = messageEmptyCart.getText().trim();
        Assert.assertEquals(actual, expectedMessage,"Message did not match");
    }


}
