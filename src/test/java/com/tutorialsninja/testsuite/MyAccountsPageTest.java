package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsPageTest extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    SuccessPage successPage = new SuccessPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    LogOut logOut = new LogOut();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyRegisterText(),"Register Account","Invalid data");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyReturningCustomer(),"Returning Customer","Invalid Data");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Jane");
        registerPage.enterLastName("Tim");
        registerPage.enterEmail("janet4@gmail.com");
        registerPage.enterTelephone("6284079342");
        registerPage.enterPassword("jane12345");
        registerPage.enterConfirmPassword("jane12345");

        registerPage.clickOnSubscribe();
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();

        Assert.assertEquals(successPage.verifyYourAccountMessage(),"Your Account Has Been Created!","Invalid data");
        successPage.clickOnSuccessContinueButton();

        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOut.verifyAccountLogoutText(),"Account Logout","Invalid data");
        logOut.clickOnContinue();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");

        loginPage.enterEmailId("janet4@gmail.com");
        loginPage.enterPassword("jane12345");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(myAccountPage.verifyMyAccount(),"My Account","Invalid Text");
        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOut.verifyAccountLogoutText(),"Account Logout","Invalid data");
        logOut.clickOnContinue();
    }

}
