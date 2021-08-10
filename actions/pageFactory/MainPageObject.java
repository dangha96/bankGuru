package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPageObject extends AbtractPage {
    WebDriver driver;
    public MainPageObject (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,MainPageObject.class);
    }



    @FindBy(xpath = "//marquee[@class='heading3']")
    private WebElement welcomeText;

    @FindBy (xpath= "//a[text()='New Customer']")
    private WebElement newCusTab;

    public String getWelcomeText() {
        waitElementVisible(driver, welcomeText);
        return getElementText(driver,welcomeText);
    }

    public void openNewCustomerPage() {
        waitElementClickable(driver,newCusTab);
        clickToElement(driver,newCusTab);
    }
}
