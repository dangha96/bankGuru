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

public class Level_04_Page_Object_Pattern extends AbstractPage {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String loginPageUrl, userID, password;
    String customerName, dobirth, address, city,state, phone, pin, email;


    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    MainPageObject mainPage;
    NewCustomerPageObject newPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", projectPath +
                "\\browserDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/v4/");
        driver.manage().window().maximize();
        loginPage = new LoginPageObject(driver);
        customerName = "ha";
        dobirth = "01-01-1996";
        address = "ABC";
        city = "united";
        state="sds";
        phone = "0343020504";
        pin = "134678";
        email = "ha" + randomNumber() + "@gmail.com";

    }

    @Test(priority = 1)
    public void verify_TC_01_Register_To_System() {
        loginPageUrl = loginPage.getLoginPageUrl();
        loginPage.clickToHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.inputToEmailTextBox("dangha" + randomNumber() + "@gmail.com");
        registerPage.clickToSubmitBtn();
        userID = registerPage.getUserText();
        password = registerPage.getPassText();
    }

    @Test(priority = 2)
    public void TC_02_Login_To_System() {
        registerPage = new RegisterPageObject(driver);
        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);
        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox(password);
        loginPage.clickToLoginBtn();
        mainPage = new MainPageObject(driver);
        Assert.assertEquals(mainPage.getWelcomeText(), "Welcome To Manager's Page of Guru99 Bank");
    }

    @Test(priority = 3)
    public void TC_03_Open_New_Customer_Page() {
        mainPage = new MainPageObject(driver);
        mainPage.openNewCustomerPage();
        newPage = new NewCustomerPageObject(driver);
        newPage.inputToNameTextBox(customerName);
        newPage.inputToDobBox(dobirth);
        newPage.inputToAddressTextBox(address);
        newPage.inputToCityTextBox(city);
        newPage.inputToPinTextBox(pin);
        newPage.inputToStateTextBox(state);
        newPage.inputToMobileTextBox(phone);
        newPage.inputToEmailTextBox(email);
        newPage.inputToPasswordTextBox(password);
        newPage.clickSubmitBtn();
        Assert.assertEquals(newPage.getSuccessMess(), "Customer Registered Successfully!!!");

    }


    //  @Test
    public void verifyWhenLoginWithIncorrectName() {
        loginPageUrl = loginPage.getLoginPageUrl();
//        loginPage.clickToHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);
        loginPage.inputInvalidUser("af");
        loginPage.inputInvalidPass("1234");
        loginPage.clickToLoginBtn();
        loginPage.verifyAlertWhenLoginUnsuccessfully();

    }


    // @Test
    public void verify_Login() {
        registerPage.openLoginPage(loginPageUrl);
        loginPage = new LoginPageObject(driver);
        loginPage.inputToUserTextBox(userID);
        loginPage.inputToPassTextBox(password);
        loginPage.clickToLoginBtn();
        mainPage = new MainPageObject(driver);
        mainPage.getWelcomeText();
        Assert.assertEquals(mainPage.getWelcomeText(), "Welcome To Manager's Page of Guru99 Bank");
    }
 /*   loginPageUrl=getCurrentUrl(driver);
        sendKeyToElement(driver,"//input[@name='uid']",userID);
        sendKeyToElement(driver,"//input[@name='password']",password);
        clickToElement(driver,"//input[@name='btnLogin']");

    public void verifyTC_01_Register_To_System() {
        loginPageUrl = loginPage.getLoginPageUrl();
        loginPage.clickToHereLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.inputToEmailTextBox("dangha" + randomNumber() + "@gmail.com");
        registerPage.clickToSubmitBtn();
        userID = registerPage.getUserText();
        password = registerPage.getPassText();

*/


    /* @Test
     public void TC_03_Open_New_Customer_Page() {
         mainPage.openNewCustomerPage();
         newPage = new NewCustomerPageObject(driver);
         newPage.inputToNameTextBox(customerName);
         newPage.inputToDobBox(dobirth);
         newPage.inputToAddressTextBox(address);
         newPage.inputToCityTextBox(city);
         newPage.inputToPinTextBox(pin);
         newPage.inputToMobileTextBox(phone);
         newPage.inputToEmailTextBox(email);
         newPage.inputToPasswordTextBox(password);
         newPage.clickSubmitBtn();
         Assert.assertEquals(newPage.getSuccessMess(), "Customer Registered Successfully!!!");

     }
 */
    @Test(priority = 4)
    public void logout() {
        registerPage.clickToLogoutLink();

        loginPage = new LoginPageObject(driver);
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
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
