package pageObjects;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUI.LoginPageUI;
import pageUI.NewCustomerUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHereLink() {
        waitElementClickable(driver, LoginPageUI.HERE_LINK);
        clickToElement(driver, LoginPageUI.HERE_LINK);


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

    public void clickToLoginBtn() {
        waitElementVisible(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
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
}
