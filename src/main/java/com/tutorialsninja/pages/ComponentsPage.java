package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {
    By componentsTest = By.xpath("//h2[text()='Components']");

    public String navigateToComponentsErrorMessage() {
        return getTextFromElement(componentsTest);
    }
}
