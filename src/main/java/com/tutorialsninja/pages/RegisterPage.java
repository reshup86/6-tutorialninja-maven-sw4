package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Utility {

    By registerAccount = By.xpath("//h1[text()='Register Account']");

    By firstName = By.id("input-firstname");
    By lsatName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");

    By agreeCheckBox = By.id("//div[@class = 'buttons']//input[@name='agree']");
    By continueButton = By.id("//div[@class = 'buttons']//input[@value='Continue']");


    public String verifyRegisterText() {
        return getTextFromElement(registerAccount);
    }

    public void enterFirstName(String text) {
        sendTextToElement(firstName, text + getAlphaNumericString(10));
    }

    public void enterLastName(String text) {
        sendTextToElement(lsatName, text + getAlphaNumericString(10));
    }

    public void enterEmail(String text) {
        sendTextToElement(email, text + getAlphaNumericString(10));
    }

    public void enterTelephone(String text) {
        sendTextToElement(telephone, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void enterConfirmPassword(String text) {
        sendTextToElement(confirmPassword, text);
    }

    public void clickOnSubscribe() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAgree() {
        clickOnElement(agreeCheckBox);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }
}
