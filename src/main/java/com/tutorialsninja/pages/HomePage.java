package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopLink = By.xpath("//div/ul/li/a[text()='Desktops']");
    By laptopNotebookLink = By.linkText("Laptops & Notebooks");
    By currency = By.xpath("//span[contains(text(),'Currency')]");

    By componentsLink = By.xpath("//a[text()='Components']");

    By myAccount = By.xpath("//span[text()='My Account']");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }
    }

    public void mouseHoverToDesktopAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverToLaptopNotebookAndClick() {
        mouseHoverToElementAndClick(laptopNotebookLink);
    }

    public void mouseHoverToComponentsAndClick() {
        mouseHoverToElementAndClick(componentsLink);
    }

    public void clickOnCurrency() {
        clickOnElement(currency);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccount);
    }

    public void clickOnRegisterLink(){
        clickOnMyAccountLink();
    }
}

