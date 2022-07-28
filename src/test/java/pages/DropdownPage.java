package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "h3")
    public WebElement pageTitle;

    @FindBy(id = "dropdown")
    public WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(){
        driver.get(baseUrl + "/dropdown");
    }
}
