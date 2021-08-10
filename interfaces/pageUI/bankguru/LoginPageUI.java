package pageUI.bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageFactory.LoginPageObject;

public class LoginPageUI {
    WebDriver driver;
    public void LoginPageObject (WebDriver driver){
        this.driver=driver;

        //Create link between value in FindBy  with variable WebElement
        PageFactory.initElements(driver,LoginPageObject.class);

    }
    public static final String HERE_LINK= "//a[text()='here']";
    public static final String USER_TEXTBOX="//input[@name='uid']";
    public static final String PASS_TEXTBOX="//input[@name='password']";
    public static final String LOGIN_BTN="//input[@name='btnLogin']";
    public static final String LOGIN_FORM="//form[@name='frmLogin']";
    //public static final String ALERT_FORM=
}
