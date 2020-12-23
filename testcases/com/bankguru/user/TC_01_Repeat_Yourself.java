package com.bankguru.user;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_01_Repeat_Yourself {
WebDriver driver;
String projectPath= System.getProperty("user.dir");
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", projectPath+
                "\\browserDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://www.demo.guru99.com/v4/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    @Test
    public void f(){

    }

    @AfterClass
    public void afterClass(){

    }

}
