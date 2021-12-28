package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SummerDressesPage extends Utility {

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-heading product-listing']//span[@class='cat-name']")
    WebElement headingText;

    @FindBy(xpath = "//div[@id='layered_price_slider']//a[2]")
    WebElement priceToSlider;

    @FindBy(xpath = "//span[@id='layered_price_range']")
    WebElement priceRangeText;

    @FindBy(xpath = "//ul[@class='product_list grid row']//li//div[@class='product-container']//div[@class='right-block']//div//span[@class='price product-price']")
    List<WebElement> listOfPrices;



    public void verifyHeadingText(String expectedText) {
        String actual = headingText.getText().trim();
        boolean ifcontains = actual.contains(expectedText);
        Assert.assertTrue(ifcontains);
    }

    // $16.00 - $21.60 // index 10 to 14
    public void setSliderPriceTo(String maxPrice) {
        WebDriverWait wait = new WebDriverWait(driver, 1000 * 60 * 2);
        //    String maxPrice = "20";
        double targetPriceTo = Double.parseDouble(maxPrice);
        System.out.println("Price To Default set to: " + priceRangeText.getText().substring(10, 15));
        String p;
        double priceTo;
        do {
            WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(priceToSlider));
            Actions movePriceTo = new Actions(driver);
            Action action = movePriceTo.dragAndDropBy(slider, -1, 0).release().build();
            action.perform();
            p = priceRangeText.getText().substring(10, 15);
            priceTo = Double.parseDouble(p);
            System.out.println("Price To after slider move, set to: " + priceRangeText.getText().substring(10, 15));
        } while (priceTo > targetPriceTo);
    }

    public void verifyIfListedProductsAreWithInSelectedPriceRange(String maxPriceSetTo) {
       // double max = 20.00;
        double max = Double.parseDouble(maxPriceSetTo);
        boolean verification = false;
        List<Double> priceListDouble = new ArrayList<>();
        for (WebElement e : listOfPrices) {
            System.out.println(e.getText().replace("$", ""));
            for (int i = 0; i < listOfPrices.size(); i++) {
                priceListDouble.add(Double.parseDouble(e.getText().replace("$", "")));
            }
        }

        for (Double price : priceListDouble) {
            System.out.println("Price in double printed: "+price);
            if (price > max) {
                verification = false;
                System.out.println("this product price is more than 20.00= " + price);
            } else {
                verification = true;
                System.out.println(("product price is within range: " + price));
            }
        }
       Assert.assertTrue(verification, "all listed prices are not within range");
    }

}
