package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class MacBookPage extends Utility {
    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By macBookAddToCart = By.xpath("//button[@id='button-cart']");

    By clickOnLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public String macBookErrorMessage() {
        return getTextFromElement(macBookText);
    }

    public void macbookAddToCart() {
        clickOnElement(macBookAddToCart);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(clickOnLink);
    }
}
