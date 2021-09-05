package pageObjects.bankguru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.bankguru.NewCustomerUI;
import pageUI.bankguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

    WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextBox (String email){
        waitElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
    }
    public void deleteTextInTextBox(){
        waitElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        clearTextBox(driver,RegisterPageUI.EMAIL_TEXTBOX);
    }
    public String getErrorMessage(){
        waitElementVisible(driver,RegisterPageUI.ERROR_TEXT);
        return getElementText(driver,RegisterPageUI.ERROR_TEXT);
    }
    public String getSuccessMessage(){
        waitElementVisible(driver, RegisterPageUI.REGIST_SUCCESS_TEXT);
        return getElementText(driver,RegisterPageUI.REGIST_SUCCESS_TEXT);
    }




    public void clickToSubmitBtn() {
        waitElementClickable(driver,RegisterPageUI.SUBMIT_BTN);
        clickToElement(driver,RegisterPageUI.SUBMIT_BTN);
    }

    public String getUserText() {
        waitElementVisible(driver,RegisterPageUI.USER_ID_TEXT);
        return getElementText(driver,RegisterPageUI.USER_ID_TEXT);
    }

    public String getPassText() {
        waitElementVisible(driver,RegisterPageUI.PASSWORD_TEXT);
        return getElementText(driver,RegisterPageUI.PASSWORD_TEXT);
    }

//    public LoginPageObject openLoginPage(String loginPageUrl) {
//        openUrl(driver,loginPageUrl);
//        return new LoginPageObject(driver);}

    public void openLoginPage(String loginPageUrl) {
       openUrl(driver,loginPageUrl);

    }
    public LoginPageObject clickToLogoutLink() {
        waitElementClickable(driver, NewCustomerUI.LOGOUT);
        clickToElement(driver,NewCustomerUI.LOGOUT);
        waitToAlertPresence(driver);
        acceptAlert(driver);
        return new LoginPageObject(driver);
    }
}
