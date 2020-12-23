package pageObjects;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextBox (String email){
        waitElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
    }

    public void clickToSubmitBtn() {
        waitElementVisible(driver,RegisterPageUI.LOGIN_BTN);
        clickToElement(driver,RegisterPageUI.LOGIN_BTN);
    }

    public String getUserText() {
        waitElementVisible(driver,RegisterPageUI.USER_ID_TEXT);
        return getElementText(driver,RegisterPageUI.USER_ID_TEXT);
    }

    public String getPassText() {
        waitElementVisible(driver,RegisterPageUI.PASSWORD_TEXT);
        return getElementText(driver,RegisterPageUI.PASSWORD_TEXT);
    }

    public void openLoginPage(String loginPageUrl) {
        openUrl(driver,loginPageUrl);
    }
}
