package com.automationpractice.testbase;

import com.automationpractice.propertyreader.PropertyReader;
import com.automationpractice.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

/*    // test to check framework template has set up successfully
    @Test
    public void test(){
        System.out.println("success");
    }*/

    @AfterMethod
    public void tearDown(){
       closeBrowser();
    }

}
