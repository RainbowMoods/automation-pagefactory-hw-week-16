package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class OurStoresPage extends Utility {

    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;

    //@CacheLookup
    @FindBy(css = "#map")
    WebElement mapArea;

    @FindBy(xpath = "//div[@id='map']")
    WebElement mapAreaByXpath;

    public void clickOKFromAlert() {
        if (okButton.isDisplayed()) {
            doClickOnElement(okButton);
        }
    }

    // below method to drag map to targeted location on y positive axis.
    public void dragMapToTarget() {
        Actions builder = new Actions(driver);
        Action drag1 = builder.moveToElement(mapArea,10,-10)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag1.perform();
        Action drag2 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag2.perform();
        Action drag3 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag3.perform();
        Action drag4 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag4.perform();
        Action drag5 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag5.perform();
        Action drag6 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag6.perform();
        Action drag7 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag7.perform();
    }

    public void takeScreenshotOfMap(WebDriver webDriver, String fileWithPath) throws IOException {

        TakesScreenshot screenshot = ((TakesScreenshot)webDriver);
        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile,DestFile);

/*        // following statement will create file name from gherkin feature statements as it is but replace space with _
        String screenShotPath = Utility.getScreenshot(driver,"screenshotname1");

        // Reporter.addScreenCaptureFromPath -- here Reporter should be of cucumber.listener
        // following method will bring with error - as it throws exception -
        // so surround by try and catch block --> from form lightBulb from left and find "surround by ...
        try {
            com.cucumber.listener.Reporter.addScreenCaptureFromPath(screenShotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }



}
