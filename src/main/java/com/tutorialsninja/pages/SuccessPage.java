package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class SuccessPage extends Utility {
    By yourAccountText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By successContinue = By.xpath("//a[contains(text(),'Continue')]");
    public String verifyYourAccountMessage(){
        return getTextFromElement(yourAccountText);
    }
    public void clickOnSuccessContinueButton(){
        clickOnElement(successContinue);
    }
}
