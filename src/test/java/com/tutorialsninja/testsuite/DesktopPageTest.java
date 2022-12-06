package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HPPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class DesktopPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    HPPage hpPage = new HPPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Desktops");
        Map<String, ArrayList> mapArrays = desktopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.clickOnCurrency();
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All DeskTops");
        // desktopPage.sortByName();
        desktopPage.clickOnHPProduct();
        Assert.assertEquals(hpPage.hpErrorMessage(), "HP LP3065", "HP LP3065 Product not display");
        hpPage.selectDate("2022", "November", "30");
        hpPage.changeProductQuantity();
        hpPage.clickOnAddToCartButton();
        hpPage.addCartMessage();
        Assert.assertEquals(hpPage.addCartMessage(), "HP LP3065", "Product not added to cart");
        hpPage.clickOnShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.shoppingCartMessage(), "Shopping Cart  (1.00kg)", "Shopping cart is not displayed");
        Assert.assertEquals(shoppingCartPage.verifyHPProduct(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2022-11-30"), "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.modelTextErrorMessage(),"Product 21","Model not matched");
        Assert.assertEquals(shoppingCartPage.macBookTotalError(),"£737.45","Total not matched");
    }

}
