package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends Utility {
    By cart = By.xpath("//div[@id='content']/h1[contains(text(), 'Shopping Cart')]");
    By hpProduct = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By model = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    By macBookProduct = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By macBookQuantity = By.xpath("//input[contains(@name, 'quantity')]");
    By macBookUpdateButton = By.xpath("//button[contains(@data-original-title, 'Update')]");

    By macBookTotal = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By checkOutButton = By.xpath("//a[contains(text(),'Checkout')]");

    public String shoppingCartMessage() {
        return getTextFromElement(cart);
    }

    public String verifyHPProduct() {
        return getTextFromElement(hpProduct);
    }

    public void deliveryDateErrorMessage() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public String modelTextErrorMessage() {
        return getTextFromElement(model);
    }

    public String totalPriceError() {
        return getTextFromElement(total);
    }

    public String verifyMacBookProduct() {
        return getTextFromElement(macBookProduct);
    }

    public void updateMacBookQuantity() {
        driver.findElement(macBookQuantity).clear();
        sendTextToElement(macBookQuantity, "2");
        clickOnElement(macBookUpdateButton);
    }
    public String macBookTotalError(){
        return getTextFromElement(macBookTotal);
    }

    public void clickOnCheckoutButton(){
        clickOnElement(checkOutButton);
    }
}
