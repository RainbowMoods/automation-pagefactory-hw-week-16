package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DressesPage extends Utility {

    public DressesPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='product_list grid row']//div[@class='right-block']//h5//a")
    List<WebElement> productNames;

    public void selectProduct(String product){
        for(WebElement element : productNames){
            if(element.getText().trim().equals(product)){
                element.click();
                break;
            }
        }
    }
}
