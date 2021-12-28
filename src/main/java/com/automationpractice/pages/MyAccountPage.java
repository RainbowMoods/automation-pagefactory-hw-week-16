package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage extends Utility {

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='nav']//div[@class='row']//div[1]//a//span")
    WebElement accountNameText;

    public void verifyAccountNameText(String accountName) {
        boolean actual = accountNameText.getText().contains(accountName);
        Assert.assertTrue(actual);
    }


}
