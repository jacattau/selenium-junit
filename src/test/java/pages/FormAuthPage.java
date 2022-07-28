package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "h2")
    public
    WebElement pageTitle;

    @FindBy(css = "h4")
    public
    WebElement subHeader;

    @FindBy(id = "username")
    public
    WebElement usernameField;

    @FindBy(id = "password")
    public
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    public
    WebElement loginButton;

    @FindBy(id = "flash")
    public
    WebElement alertBanner;

    @FindBy(css = "a[class='button secondary radius']")
    public
    WebElement logoutButton;

    public FormAuthPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(){
        driver.get(baseUrl + "/login");
    }
}
