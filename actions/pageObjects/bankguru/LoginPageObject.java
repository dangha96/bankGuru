package pageObjects.bankguru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUI.bankguru.LoginPageUI;
import pageUI.bankguru.NewCustomerUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

//ham khoi tao
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public RegisterPageObject clickToHereLink() {
        waitElementClickable(driver, LoginPageUI.HERE_LINK);
        clickToElement(driver, LoginPageUI.HERE_LINK);
        return new RegisterPageObject(driver);
    }

    public String getLoginPageUrl() {
        return getCurrentUrl(driver);
    }

    public void inputInvalidUser(String invalidUser) {
        waitElementVisible(driver,LoginPageUI.USER_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.USER_TEXTBOX,invalidUser);
    }
    public void inputInvalidPass(String invalidPass){
        waitElementVisible(driver,LoginPageUI.PASS_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASS_TEXTBOX,invalidPass);
    }
    public void inputToUserTextBox(String userID) {
        waitElementVisible(driver, LoginPageUI.USER_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_TEXTBOX, userID);
    }

    public void inputToPassTextBox(String password) {
        waitElementVisible(driver, LoginPageUI.PASS_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASS_TEXTBOX, password);
    }
    public void clickToLoginBtnInvalid() {
        waitElementVisible(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        waitToAlertPresence(driver);
        acceptAlert(driver);
    }

    public MainPageObject clickToLoginBtn() {
        waitElementVisible(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        return new MainPageObject(driver);
    }

    public boolean isLoginFormDisplayed() {
        waitElementVisible(driver, LoginPageUI.LOGIN_FORM);
        return isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
    }

    public void clickToLogoutLink() {
        waitElementClickable(driver, NewCustomerUI.LOGOUT);
        clickToElement(driver, NewCustomerUI.LOGOUT);
        waitToAlertPresence(driver);
        acceptAlert(driver);
    }
    public void verifyAlertWhenLoginUnsuccessfully()  {
        waitToAlertPresence(driver);
        sleepInSecond(3);
        Assert.assertEquals(verifyGetTextAlert(driver),"User or Password is not valid");
        acceptAlert(driver);

    }
}
