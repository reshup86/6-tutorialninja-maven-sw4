package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {

    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");

    By myAccount = By.xpath("//h2[text()='My Account']");
    public void clickOnMyAccountLink(){
        clickOnElement(myAccountLink);
    }
    public String verifyMyAccount(){
        return getTextFromElement(myAccount);
    }
}
