package pageObjects;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.NewCustomerUI;

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
        waitElementVisible(driver,NewCustomerUI.DOB);
        removeAttributeInDOM(driver,NewCustomerUI.DOB,"type");
        sendKeyToElement(driver,NewCustomerUI.DOB,dob);
    }

    public void inputToAddressTextBox(String address) {
        waitElementVisible(driver,NewCustomerUI.ADDRESS);
        sendKeyToElement(driver,NewCustomerUI.ADDRESS,address);
    }

    public void inputToCityTextBox(String city) {
        waitElementVisible(driver,NewCustomerUI.CITY);
        sendKeyToElement(driver,NewCustomerUI.CITY,city);
    }

    public void inputToPinTextBox(String pin) {
        waitElementVisible(driver,NewCustomerUI.PIN);
        sendKeyToElement(driver,NewCustomerUI.PIN,pin);
    }

    public void inputToMobileTextBox(String mobile) {
        waitElementVisible(driver,NewCustomerUI.MOBILE);
        sendKeyToElement(driver,NewCustomerUI.MOBILE, mobile);
    }

    public void inputToEmailTextBox(String email) {
        waitElementVisible(driver,NewCustomerUI.EMAIL);
        sendKeyToElement(driver,NewCustomerUI.EMAIL,email);
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

    public void clickToLogoutLink() {
        waitElementClickable(driver,NewCustomerUI.LOGOUT);
        clickToElement(driver,NewCustomerUI.LOGOUT);
        waitToAlertPresence(driver);
        acceptAlert(driver);
    }
}
