package com.bankguru.user;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_02_Abstract_Page {

    WebDriver driver;
    String projectPath= System.getProperty("user.dir");
    String loginPageUrl, userID,password;
    AbstractPage abstractPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", projectPath+
                "\\browserDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        abstractPage= new AbstractPage() ;
        abstractPage.openUrl(driver,"http://www.demo.guru99.com/v4/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    @Test
    public void verifyTC_01_Register_To_System(){
        loginPageUrl=abstractPage.getCurrentUrl(driver);
        abstractPage.clickToElement(driver,"//a[text()='here']");
        abstractPage.sendKeyToElement(driver,"//input[@name='emailid']","dangha@gmail.com");
        abstractPage.clickToElement(driver,"//input[@name='btnLogin']");

    }

    @AfterClass
    public void afterClass(){

    }


}
