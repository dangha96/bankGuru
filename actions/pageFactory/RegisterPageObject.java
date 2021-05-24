package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject {

    @FindBy (xpath = "//input[@type='text']")
    private WebElement emailTextBox;

    @FindBy (xpath= "//input[@value='Submit']")
    private WebElement loginBtn;

    @FindBy (xpath = "//td[text()='User ID :']//following-sibling::td")
    private WebElement userIDText;

    @FindBy (xpath = "//td[text()='Password :']//following-sibling::td")
    private WebElement passText;


}

