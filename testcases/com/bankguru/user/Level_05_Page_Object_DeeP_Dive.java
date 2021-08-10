package com.bankguru.user;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.MainPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.RegisterPageObject;

import java.util.Random;

public class Level_05_Page_Object_DeeP_Dive extends AbstractPage {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String loginPageUrl, userID, password;
    String customerName;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    MainPageObject mainPage;
    NewCustomerPageObject newPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", projectPath +
                "\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/v4/");
        driver.manage().window().maximize();
        loginPage = new LoginPageObject(driver);

    }

    @Test
    public void verifyTC_01_Login_With_Empty_User_Password() {
       loginPage.inputToUserTextBox("");
        loginPage.inputToPassTextBox("");
        loginPage.clickToLoginBtn();

//        clickToElement(driver,"//a[text()='here']");
//        sendKeyToElement(driver,"//input[@name='emailid']","dangha@gmailcom");
//        clickToElement(driver,"//input[@name='btnLogin']");
//        userID=getElementText(driver,"//td[text()='User ID :']//following-sibling::td");
//        password=getElementText(driver,"//td[text()='Password :']//following-sibling::td");

    }

    @Test
    public void verify_Login_Empty_User() {

        loginPage.inputToUserTextBox("");
        loginPage.inputToPassTextBox(password);

    }

    @Test
    public void verify_Login_Empty_Pass() {

        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox("");

    }

    @Test
    public void verify_Login_Invalid_User() {

        loginPage.inputToUserTextBox("abc");
        loginPage.inputToPassTextBox(password);

    }

    @Test
    public void verify_Login_Invalid_Pass() {

        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox("124");

    }
    @Test
    public void verify_Login_Valid_User_Pass() {

        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox(password);

    }


    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }


}
