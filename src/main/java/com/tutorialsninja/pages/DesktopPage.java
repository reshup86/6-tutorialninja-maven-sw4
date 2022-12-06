package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class DesktopPage extends Utility {
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By sortByAToZ = By.xpath("//select[@id='input-sort']");
    By hpProduct = By.xpath("//a[contains(text(),'HP LP3065')]");

    public String navigateToDesktopErrorMessage() {
        return getTextFromElement(desktopText);

    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;
        // Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);
    }

    public void sortByName() {
        selectByVisibleTextFromDropDown(sortByAToZ, "Name (A - Z)");
    }
    public void clickOnHPProduct(){
        clickOnElement(hpProduct);
    }
}
