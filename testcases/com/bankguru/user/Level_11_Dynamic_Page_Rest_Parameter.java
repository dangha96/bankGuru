package com.bankguru.user;

import common.AbstractTest;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.MainPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.RegisterPageObject;

public class Level_11_Dynamic_Page_Rest_Parameter extends AbstractTest {
    WebDriver driver;
    String loginPageUrl, userID, password;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    NewCustomerPageObject newPage;
    MainPageObject mainPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

//        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_01_Register_To_System() {
        loginPageUrl = loginPage.getLoginPageUrl();
        registerPage = loginPage.clickToHereLink();
        registerPage.inputToEmailTextBox("ha@gmail.com");
        registerPage.clickToSubmitBtn();
        userID = registerPage.getUserText();
        password = registerPage.getPassText();
    }

    //10 pages
    public void TC_02_Dynamic_Page() {
        //Main page > new customer
        newPage = (NewCustomerPageObject) mainPage.openMenuPageByName(driver, "New Customer");
    }

    //100 page
    public void TC_03_Many_Dynamic_Page() {
        //Main page > new customer
        mainPage.openManyPageByName(driver, "New Customer");
        newPage= PageGeneratorManager.getNewCustomerPage(driver);
    }

    @Test
    public void logout() {
        newPage.clickToLogoutLink();

        loginPage = new LoginPageObject(driver);
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }
}
