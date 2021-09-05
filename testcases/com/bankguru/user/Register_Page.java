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
import pageUI.bankguru.RegisterPageUI;

import java.util.Random;

public class Register_Page extends AbstractPage {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String loginPageUrl, userID, password;
    String email;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;


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
    public void TC_01_Invalid_UserName() {
        loginPageUrl = loginPage.getLoginPageUrl();
        loginPage.clickToHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.inputToEmailTextBox("dangha" + randomNumber());
        registerPage.getErrorMessage();
        Assert.assertEquals(registerPage.getErrorMessage(), "Email ID is not valid");
    }

    @Test(priority = 2)
    public void TC_02_Empty_UserName() {
        registerPage.inputToEmailTextBox("");
        registerPage.getErrorMessage();
        Assert.assertEquals(registerPage.getErrorMessage(), "Email ID must not be blank");
    }

    @Test(priority = 3)
    public void TC_03_Register_To_System() {
        registerPage = new RegisterPageObject(driver);
        registerPage.inputToEmailTextBox("dangha" + randomNumber() + "@gmail.com");
        registerPage.clickToSubmitBtn();
        Assert.assertEquals(registerPage.getSuccessMessage(), "Please take SCREESNSHOT of this page for future reference.");
        userID = registerPage.getUserText();
        password = registerPage.getPassText();

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
