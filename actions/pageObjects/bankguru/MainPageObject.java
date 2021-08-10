package pageObjects.bankguru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.bankguru.MainPageUI;

public class MainPageObject extends AbstractPage {
    WebDriver driver;
    public MainPageObject(WebDriver driver) {

        this.driver = driver;
    }

    public String getWelcomeText() {
        waitElementVisible(driver,MainPageUI.WELCOM_TEXT);
        return getElementText(driver,MainPageUI.WELCOM_TEXT);
    }

    public NewCustomerPageObject openNewCustomerPage() {
        waitElementClickable(driver,MainPageUI.NEW_CUS_TAB);
        clickToElement(driver,MainPageUI.NEW_CUS_TAB);
        return new NewCustomerPageObject(driver);
    }


}
