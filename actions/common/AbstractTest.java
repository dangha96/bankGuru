package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.LoginPageObject;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    public WebDriver getBrowserDriver(String browserName) {
//        if (browserName.contains("chrome")) {
//            System.setProperty("webdriver.chrome.driver", projectPath +
//                    "\\browserDriver\\chromedriver.exe");
//            driver = new ChromeDriver();
//        } else if (browserName.contains("firefox")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
//            driver = new FirefoxDriver();
//        } else if (browserName.contains("hchrome")) {
//            System.setProperty("webdriver.chrome.driver", projectPath +
//                    "\\browserDriver\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.setHeadless(true);
////            options.addArguments("--headless");
//            options.addArguments("window-size=1920x1080");
//            driver = new ChromeDriver(options);
//        } else {
//            throw new RuntimeException("Please choose browser name");
//        }
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath +
                        "\\browserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "chromeheadless":
                System.setProperty("webdriver.chrome.driver", projectPath +
                        "\\browserDriver\\chromedriver.exe");
                ChromeOptions chromeOpt = new ChromeOptions();
                chromeOpt.setHeadless(true);
//            options.addArguments("--headless");
                chromeOpt.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chromeOpt);
                break;
            case"firefoxheadless":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
                FirefoxOptions firefoxOpt=new FirefoxOptions();
                firefoxOpt.addArguments("window-size=1920x1080");
                driver=new FirefoxDriver(firefoxOpt);
                break;
            default:
                throw new RuntimeException("Please choose browser name");
        }


        driver.get("http://www.demo.guru99.com/v4/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
