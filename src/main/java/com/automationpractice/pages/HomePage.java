package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }


    @CacheLookup
    @FindBy(xpath = "//div[@id='block_top_menu']//li")
    List<WebElement> menuBarLocatorByCustomXPath;

    @FindBy(xpath = "//header[@id='header']//div[2]//div//div//div[1]//a")
    WebElement signInOrSingOutLink;

    @FindBy(xpath = "//section[@id='block_various_links_footer']//ul//li//a")
    List<WebElement> listOfInformationLinks;


    public void selectInformation(String info){
        for (WebElement e : listOfInformationLinks){
            if(e.getText().equalsIgnoreCase(info)){
                doClickOnElement(e);
                break;
            }
        }
    }

    // click on sig in link
    public void clickOnSignInLink() {
        doClickOnElement(signInOrSingOutLink);
        Reporter.log("click on sign in link"+signInOrSingOutLink.getText()+"<br>");
    }



    public void selectMenu(String menu){
        for(WebElement element : menuBarLocatorByCustomXPath){
            if(element.getText().trim().equals(menu)){
                element.click();
                break;
            }
        }
    }

    public void hoverMouseToMenu(String menu){
        for(WebElement element: menuBarLocatorByCustomXPath){
            if(element.getText().trim().equals(menu)){
                doMouseHoverTo(element);
                break;
            }
        }
    }

    public void hoverMouseAndClickOnSubMenu(String subMenu){
        for(WebElement element: menuBarLocatorByCustomXPath){
            if(element.getText().trim().equals(subMenu)){
                doMouseHoverAndClick(element);
                break;
            }
        }
    }



}
