package pageUI.bankguru;


import common.AbstractPage;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageUI {
    public static final String LOGOUT_LINK="//a[text()='Log out']";
    public static final String NEW_CUSTOMER_LINK="//a[text()='New Customer']";
    public static final String EDIT_CUSTOMER_LINK="//a[text()='Edit Account']";
    public static final String DEPOSIT_LINK="//a[text()='Deposit']";
    public static final String FUND_TRANFER_LINK="//a[text()='Fund Transfer']";
    //Dynamic locator
    public static final String DYNAMIC_MENU_PAGE_LINK="//a[text()='$s']";
}

//    public void waitElementClickable(WebDriver driver, String locator, String... values) {
//        explicitWait = new WebDriverWait(driver, longTimeOut);
//        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToRestParameter(locator, values))));
//    }
//
//    public AbstractPage openMenuPageByName(WebDriver driver, String pageName){
//        waitElementClickable(driver, AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
//        clickToElement(driver,AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
//        if(pageName.equals("New Customer")){
//            return PageGeneratorManager.getNewCustomerPage(driver);
//        } else {
//            throw new RuntimeException();
//        }
//
//    }
