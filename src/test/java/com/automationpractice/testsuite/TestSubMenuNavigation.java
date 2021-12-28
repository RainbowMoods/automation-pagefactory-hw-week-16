package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDressesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSubMenuNavigation extends TestBase {

    HomePage homePage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        summerDressesPage = new SummerDressesPage();
    }


    /**
     * As a user I want to select the 'Summer Dresses' option from the navigation menu,
     * so that I can view an item from the summer collection.
     *
     * Acceptance Criteria:
     * - On mouse-hover button 'WOMAN', sub navigation options will appear
     * - Summer items only display inside the search results.
     */
    @Test
    @Parameters({"menu","subMenu","expectedText"})
    public void verifyIfUserIsAbleToNavigateToSummerDressesOptionAndIsAbleToViewItemFromTheSummerCollection(String menu, String subMenu, String expectedText){

        // hover mouse to 'WOMEN'
        new HomePage().hoverMouseToMenu(menu);
        // hover mouse and click on submenu 'Summer Dresses'
        new HomePage().hoverMouseAndClickOnSubMenu(subMenu);
        // verify if heading of page is "SUMMER DRESSES"
        new SummerDressesPage().verifyHeadingText(expectedText);
    }

    /**
     * As a user when searching for a summer dress,
     * I want to change the price range to $16 - $20 so that I see the search results change.
     * <p>
     * Acceptance Criteria:
     * - Slider changes the price range
     * - Search results are updated
     * - Items returned are within the price range
     */
    @Test
    @Parameters({"menu", "subMenu", "expectedText", "setMaxPrice"})
    public void verifyIfUserIsAbleToFilterPriceChangeAndSeeTheChangeInSearchResults(String menu, String subMenu, String expectedText, String setMaxPrice) {
        // hover mouse to 'WOMEN'
        new HomePage().hoverMouseToMenu(menu);
        // hover mouse and click on submenu 'Summer Dresses'
        new HomePage().hoverMouseAndClickOnSubMenu(subMenu);
        // verify if heading of page is "SUMMER DRESSES"
        new SummerDressesPage().verifyHeadingText(expectedText);
        // change the price range on slider from "$16" to "$20"
        new SummerDressesPage().setSliderPriceTo(setMaxPrice);
        // verify if search results are priced withing the selected range
        new SummerDressesPage().verifyIfListedProductsAreWithInSelectedPriceRange(setMaxPrice);
    }
}
