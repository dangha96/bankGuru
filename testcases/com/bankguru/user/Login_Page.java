package com.bankguru.user;

import common.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.bankguru.LoginPageObject;
import pageObjects.bankguru.MainPageObject;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.RegisterPageObject;

import java.util.Random;

public class Login_Page extends AbstractPage {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String loginPageUrl, userID, password;
    String email;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    MainPageObject mainPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", projectPath +
                "\\browserDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/v4/");
        driver.manage().window().maximize();
        loginPage = new LoginPageObject(driver);
        email = "ha" + randomNumber() + "@gmail.com";

    }

    @Test(priority = 1)
    public void register_Account() {
        loginPageUrl = loginPage.getLoginPageUrl();
        loginPage.clickToHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.inputToEmailTextBox("dangha" + randomNumber() + "@gmail.com");
        registerPage.clickToSubmitBtn();
        userID = registerPage.getUserText();
        password = registerPage.getPassText();
    }

    @Test(priority = 2)
    public void TC_01_Login_Incorrect_Name() {
        registerPage = new RegisterPageObject(driver);
        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);
        loginPage.inputInvalidUser("af");
        loginPage.inputInvalidPass("1234");
        loginPage.clickToLoginBtn();
        loginPage.verifyAlertWhenLoginUnsuccessfully();
    }


    @Test(priority = 3)
    public void TC_02_Login_Incorrect_Password() {
        registerPage = new RegisterPageObject(driver);
        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);
        loginPage.inputInvalidUser(userID);
        loginPage.inputInvalidPass("1234");
        loginPage.clickToLoginBtn();
        loginPage.verifyAlertWhenLoginUnsuccessfully();
    }

    @Test(priority = 4)
    public void TC_03_Empty_User_And_Password() {
        loginPage = new LoginPageObject(driver);
        loginPage.inputInvalidUser("");
        loginPage.clickOutside();
        loginPage.getErrorEmptyUser();
        Assert.assertEquals(loginPage.getErrorEmptyUser(), "User-ID must not be blank");
        loginPage.inputInvalidPass("");
        loginPage.clickOutside();
        loginPage.getErrorEmptyPassWord();
        Assert.assertEquals(loginPage.getErrorEmptyPassWord(), "Password must not be blank");
        loginPage.clickToLoginBtn();
        loginPage.verifyAlertWhenLoginUnsuccessfully();
    }

    @Test(priority = 5)
    public void TC_02_Login_To_System() {
        loginPage = new LoginPageObject(driver);
        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox(password);
        loginPage.clickToLoginBtn();
        mainPage = new MainPageObject(driver);
        Assert.assertEquals(mainPage.getWelcomeText(), "Welcome To Manager's Page of Guru99 Bank");
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
