package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MacBookPage macBookPage = new MacBookPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");

        Map<String, ArrayList> mapArrays = laptopsAndNotebooksPage.arrangeProductHighToLowOrder();
        Assert.assertEquals(mapArrays.get("originalProductsPrice"), mapArrays.get("afterSortByPrice"));
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.clickOnCurrency();
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        //laptopsAndNotebooksPage.productsSortBy();
        laptopsAndNotebooksPage.clickOnMacBookLink();
        Assert.assertEquals(macBookPage.macBookErrorMessage(), "MacBook", "MacBook Product not display");
        macBookPage.macbookAddToCart();
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")).contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        macBookPage.clickOnShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.shoppingCartMessage(), "Shopping Cart  (0.00kg)", "Shopping cart is not displayed");
        Assert.assertEquals(shoppingCartPage.verifyMacBookProduct(), "MacBook", "Product name not matched");
        shoppingCartPage.updateMacBookQuantity();
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"), "Cart not modified");
        shoppingCartPage.clickOnCheckoutButton();

        Assert.assertEquals(checkOutPage.verifyCheckoutText(), "Checkout", "Invalid text displayed");
        //Assert.assertEquals(checkOutPage.verifyCustomerText(),"New Customer","Invalid text displayed");
        checkOutPage.clickOnGuestCheckOut();

        checkOutPage.enterFirstName("John");
        checkOutPage.enterLastName("Smith");
        checkOutPage.enterEmail("test@example.com");
        checkOutPage.enterTelephone("6329576580");
        checkOutPage.enterAddress("11,Sweet Home");
        checkOutPage.enterCity("London");
        checkOutPage.enterPostcode("N3 4RT");
        checkOutPage.enterCountry("222");
        checkOutPage.enterState("3523");
        checkOutPage.clickOnCheckButton();

        checkOutPage.addComments();
        checkOutPage.clickOnCheckBox();
        checkOutPage.clickOnCheckOutContinue();


    }
}
