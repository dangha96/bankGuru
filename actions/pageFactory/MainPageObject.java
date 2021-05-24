package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject {
    @FindBy(xpath = "//marquee[@class='heading3']")
    private WebElement welcomeText;

    @FindBy (xpath= "//a[text()='New Customer']")
    private WebElement newCusTab;
}
