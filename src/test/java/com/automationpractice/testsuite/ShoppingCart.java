package com.automationpractice.testsuite;

import com.automationpractice.pages.DressesPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.ShoppingCartPage;
import com.automationpractice.pages.SummerDressesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShoppingCart extends TestBase {

    DressesPage dressesPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod (alwaysRun = true)
    public void init() {
        dressesPage = new DressesPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        summerDressesPage = new SummerDressesPage();
    }


    /**
     * As a user if there is an item already inside my basket, I want to be able to delete the item from the basket page
     * so that I can see the basket is empty
     * <p>
     * Acceptance Criteria:
     * -Shopping cart has Delete button
     * Item is removed from basket/cart
     * Banner must display 'Your cart is emplty.'
     */

    @Test
    @Parameters({"menu", "product", "expectedMessage"})
    public void verifyIfUserIsAbleToEmptyTheShoppingCart(String menu, String product, String expectedMessage) throws InterruptedException {
        // select menu "DRESSES"
        new HomePage().selectMenu(menu);
        // add to select product "Printed Chiffon Dress"
        new DressesPage().selectProduct(product);
        // click on add to cart button
        new ProductPage().clickOnAddToCartButton();
        // click on Proceed to checkout button
        new ProductPage().clickOnProceedToCheckoutButton();
        // verify if delete button is available in shopping cart
        new ShoppingCartPage().verifyNumberOfProducts();
        Thread.sleep(2000);
        // verify if delete button is available
        new ShoppingCartPage().verifyDeleteButtonIsAvailable();
        Thread.sleep(2000);
        // click on delete button
        new ShoppingCartPage().clickOnDeleteButton();
        Thread.sleep(3000);
        //verify banner message 'Your shopping cart is empty.'
        new ShoppingCartPage().verifyMessageOfShoppingCartIsEmpty(expectedMessage);
    }


}
