package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "h3")
    public WebElement pageTitle;

    @FindBy(css = "h3 + p")
    public WebElement subHeaderTop;

    @FindBy(css = "h3 + p + p")
    public WebElement subHeaderBottom;

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    public WebElement example1Link;

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    public WebElement example2Link;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(){
        driver.get(baseUrl + "/dynamic_loading");
    }
}
