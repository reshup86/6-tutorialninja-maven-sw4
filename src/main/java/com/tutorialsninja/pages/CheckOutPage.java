package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    By checkOutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By clickOnRadioButton = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By clickOnContinueButton = By.id("button-account");

    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postcode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By state = By.id("input-payment-zone");

    By clickOnGuestButton = By.id("button-guest");
    By addCommentsText = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]");

    By addTerms = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]");

    By checkOutContinue = By.id("button-payment-method");

    By warningText = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]");


    public String verifyCheckoutText() {
        return getTextFromElement(checkOutText);
    }

    public String verifyCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckOut() {
        clickOnElement(clickOnRadioButton);
        clickOnElement(clickOnContinueButton);
    }

    public void enterFirstName(String text) {
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text) {
        sendTextToElement(lastName, text);
    }

    public void enterEmail(String text) {
        sendTextToElement(email, text);
    }

    public void enterTelephone(String text) {
        sendTextToElement(telephone, text);
    }

    public void enterAddress(String text) {
        sendTextToElement(address, text);
    }

    public void enterCity(String text) {
        sendTextToElement(city, text);
    }

    public void enterPostcode(String text) {
        sendTextToElement(postcode, text);
    }

    public void enterCountry(String text) {
        selectByValueFromDropDown(country, text);
    }

    public void enterState(String text) {
        selectByValueFromDropDown(state, text);
    }

    public void clickOnCheckButton() {
        clickOnElement(clickOnGuestButton);
    }

    public void addComments() {
        sendTextToElement(addCommentsText, "not available");
    }

    public void clickOnCheckBox() {
        clickOnElement(addTerms);
    }

    public void clickOnCheckOutContinue() {
        clickOnElement(checkOutContinue);
    }

    public String warningMessage() {
        return getTextFromElement(warningText);
    }
}
