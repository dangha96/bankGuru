package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbtractPage {
    WebDriver driver;
    public RegisterPageObject (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        // Create link between value in FindBy and variable WebElement
    }

    @FindBy (name = "emailId")
    private WebElement emailTextBox;

    @FindBy (xpath= "//input[@value='Submit']")
    private WebElement loginBtn;

    @FindBy (xpath = "//td[text()='User ID :']//following-sibling::td")
    private WebElement userIDText;

    @FindBy (xpath = "//td[text()='Password :']//following-sibling::td")
    private WebElement passText;


    public void inputToEmailTextBox (String email){
        waitElementVisible(driver,emailTextBox);
        sendKeyToElement(driver,emailTextBox,email);
    }

    public void clickToSubmitBtn() {
        waitElementVisible(driver,loginBtn);
        clickToElement(driver,loginBtn);
    }

    public String getUserText() {
        waitElementVisible(driver,userIDText);
        return getElementText(driver,userIDText);
    }

    public String getPassText() {
        waitElementVisible(driver,passText);
        return getElementText(driver,passText);
    }

    public void openLoginPage(String loginPageUrl) {
        openUrl(driver,loginPageUrl);
    }

}

