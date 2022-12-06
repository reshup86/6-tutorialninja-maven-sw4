package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HPPage extends Utility {
    By hpText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By inputQuantity = By.id("input-quantity");
    By clickOnButton = By.xpath("//button[@id='button-cart']");
    By addToCartText = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h1[1]");

    By clickOnLink = By.xpath("//a[contains(text(),'shopping cart')]");



    public String hpErrorMessage() {
        return getTextFromElement(hpText);
    }

    public void selectDate(String year, String month, String date) {

        clickOnElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='picker-switch']")).getText(); // Nov 2022
            String arr[] = monthYear.split(" ");

            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='next']"));
            }
        }

        // select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']/tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

    }

    public void changeProductQuantity() {
        driver.findElement(inputQuantity).clear();
        sendTextToElement(inputQuantity, "1");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(clickOnButton);
    }

    public String addCartMessage() {
        return getTextFromElement(addToCartText);
    }

    public void clickOnShoppingCartLink(){
        clickOnElement(clickOnLink);
    }
}
