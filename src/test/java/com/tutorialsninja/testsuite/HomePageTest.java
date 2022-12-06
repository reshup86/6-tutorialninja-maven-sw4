package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All Desktops");
        String expectedDesktopText = "Desktops";
        Assert.assertEquals(desktopPage.navigateToDesktopErrorMessage(), expectedDesktopText, "Desktops text is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverToLaptopNotebookAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedLaptopAndNotebookText = "Laptops & Notebooks";
        Assert.assertEquals(laptopsAndNotebooksPage.navigateToLaptopAndNotebookErrorMessage(), expectedLaptopAndNotebookText, "Laptop and desktop text is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverToComponentsAndClick();
        homePage.selectMenu("Show All Components");
        String expectedComponentsErrorText = "Components";
        Assert.assertEquals(componentsPage.navigateToComponentsErrorMessage(),expectedComponentsErrorText,"Components text is not displayed");
    }
}
