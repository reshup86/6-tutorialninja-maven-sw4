package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By returningCustomerText = By.xpath("//h2[text()='Returning Customer']");

    By emailID = By.id("input-email");
    By password = By.id("input-password");
    By clickOnLogin = By.xpath("//input[@class='btn btn-primary']");
    public String verifyReturningCustomer(){
        return getTextFromElement(returningCustomerText);
    }

    public void enterEmailId(String text){
        sendTextToElement(emailID,text);
    }
    public void enterPassword(String text){
        sendTextToElement(password,text);
    }
    public void clickOnLoginButton(){
        clickOnElement(clickOnLogin);
    }
}
