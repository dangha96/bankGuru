package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObject extends AbtractPage {
    WebDriver driver;
    public LoginPageObject (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, LoginPageObject.class);
        // Create link between value in FindBy and variable WebElement
    }
    //findBy/ findBys/ findAll
    @FindBy (xpath = "a[text()='here']")
    private WebElement herLink;

    @FindBy (name = "uid")
    private WebElement userTextBox;

    @FindBy (name = "password")
    private WebElement passWord;

    @FindBy (name = "btnLogin")
    private WebElement loginBtn;

    @FindBy (css = "form[@name='frmLogin']")
    private WebElement loginForm;


    public void clickToHereLink() {
        waitElementClickable(driver, herLink);
        clickToElement(driver, herLink);
    }

    public String getLoginPageUrl() {
        return getCurrentUrl(driver);
    }

    public void inputInvalidUser(String invalidUser) {
        waitElementVisible(driver,userTextBox);
        sendKeyToElement(driver,userTextBox,invalidUser);
    }
    public void inputInvalidPass(String invalidPass){
        waitElementVisible(driver,passWord);
        sendKeyToElement(driver,passWord,invalidPass);
    }
    public void inputToUserTextBox(String userID) {
        waitElementVisible(driver, userTextBox);
        sendKeyToElement(driver, userTextBox, userID);
    }

    public void inputToPassTextBox(String password) {
        waitElementVisible(driver, passWord);
        sendKeyToElement(driver, passWord, password);
    }
    public void clickToLoginBtnInvalid() {
        waitElementVisible(driver,loginBtn);
        clickToElement(driver, loginBtn);
        waitToAlertPresence(driver);
        acceptAlert(driver);
    }

    public void clickToLoginBtn() {
        waitElementVisible(driver, loginBtn);
        clickToElement(driver, loginBtn);
    }

    public boolean isLoginFormDisplayed() {
        waitElementVisible(driver, loginForm);
        return isControlDisplayed(driver,loginForm);
    }

//    public void clickToLogoutLink() {
//        waitElementClickable(driver, );
//        clickToElement(driver,);
//        waitToAlertPresence(driver);
//        acceptAlert(driver);
//    }
    public void verifyAlertWhenLoginUnsuccessfully()  {
        waitToAlertPresence(driver);
        sleepInSecond(3);
        Assert.assertEquals(verifyGetTextAlert(driver),"User or Password is not valid");
        acceptAlert(driver);

    }

}
