package pageObjects.bankguru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.bankguru.NewCustomerUI;

public class NewCustomerPageObject extends AbstractPage {
    WebDriver driver;
    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToNameTextBox(String customerName) {
        waitElementVisible(driver, NewCustomerUI.CUSTOMER_NAME);
        sendKeyToElement(driver,NewCustomerUI.CUSTOMER_NAME,customerName);
    }

    public void inputToDobBox(String dob) {
        waitElementVisible(driver,NewCustomerUI.DOB_TEXTBOX);
        removeAttributeInDOM(driver,NewCustomerUI.DOB_TEXTBOX,"type");
        sendKeyToElement(driver,NewCustomerUI.DOB_TEXTBOX,dob);
    }

    public void inputToAddressTextBox(String address) {
        waitElementVisible(driver,NewCustomerUI.ADDRESS_TEXTAREA);
        sendKeyToElement(driver,NewCustomerUI.ADDRESS_TEXTAREA,address);
    }

    public void inputToCityTextBox(String city) {
        waitElementVisible(driver,NewCustomerUI.CITY_TEXTBOX);
        sendKeyToElement(driver,NewCustomerUI.CITY_TEXTBOX,city);
    }

    public void inputToPinTextBox(String pin) {
        waitElementVisible(driver,NewCustomerUI.PIN_TEXTBOX);
        sendKeyToElement(driver,NewCustomerUI.PIN_TEXTBOX,pin);
    }
    public void inputToStateTextBox(String state) {
        waitElementVisible(driver,NewCustomerUI.STATE_TEXTBOX);
        sendKeyToElement(driver,NewCustomerUI.STATE_TEXTBOX,state);
    }

    public void inputToMobileTextBox(String mobile) {
        waitElementVisible(driver,NewCustomerUI.MOBILE_TEXTBOX);
        sendKeyToElement(driver,NewCustomerUI.MOBILE_TEXTBOX, mobile);
    }

    public void inputToEmailTextBox(String email) {
        waitElementVisible(driver,NewCustomerUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,NewCustomerUI.EMAIL_TEXTBOX,email);
    }

    public void inputToPasswordTextBox(String pass) {
        waitElementVisible(driver,NewCustomerUI.PASS);
        sendKeyToElement(driver,NewCustomerUI.PASS,pass);

    }

    public void clickSubmitBtn() {
        waitElementClickable(driver, NewCustomerUI.SUBMIT_BTN);
        clickToElement(driver,NewCustomerUI.SUBMIT_BTN);
    }

    public String getSuccessMess() {
        waitElementVisible(driver,NewCustomerUI.NEW_SUCCESS_MESS);
        return getElementText(driver,NewCustomerUI.NEW_SUCCESS_MESS);
    }

    public LoginPageObject clickToLogoutLink() {
        waitElementClickable(driver,NewCustomerUI.LOGOUT);
        clickToElement(driver,NewCustomerUI.LOGOUT);
        waitToAlertPresence(driver);
        acceptAlert(driver);
        return new LoginPageObject(driver);
    }
}
