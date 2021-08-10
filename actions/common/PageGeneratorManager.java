package common;

import org.openqa.selenium.WebDriver;
import pageFactory.LoginPageObject;
import pageFactory.MainPageObject;
import pageFactory.RegisterPageObject;
import pageObjects.bankguru.NewCustomerPageObject;

public class PageGeneratorManager {
    //return new login page
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage (WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static MainPageObject getMainPage(WebDriver driver){
        return new MainPageObject(driver);
    }

    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver){
        return new NewCustomerPageObject(driver);
    }

}
