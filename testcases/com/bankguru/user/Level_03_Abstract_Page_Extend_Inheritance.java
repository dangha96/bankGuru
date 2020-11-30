package com.bankguru.user;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_03_Abstract_Page_Extend_Inheritance extends AbstractPage{

    WebDriver driver;
    String projectPath= System.getProperty("user.dir");
    String loginPageUrl, userID,password;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", projectPath+
                "\\browserDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        openUrl(driver,"http://www.demo.guru99.com/v4/");

    }
    @Test
    public void verifyTC_01_Register_To_System(){
        loginPageUrl=getCurrentUrl(driver);
        clickToElement(driver,"//a[text()='here']");
        sendKeyToElement(driver,"//input[@name='emailid']","dangha@gmailcom");
        clickToElement(driver,"//input[@name='btnLogin']");

    }

    @AfterClass
    public void afterClass(){

    }


}
