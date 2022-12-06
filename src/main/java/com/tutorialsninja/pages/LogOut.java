package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LogOut extends Utility {

    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    public String verifyAccountLogoutText(){
        return getTextFromElement(accountLogoutText);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
}
