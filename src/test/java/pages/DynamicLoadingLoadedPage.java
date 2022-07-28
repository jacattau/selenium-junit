package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingLoadedPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "h3")
    public WebElement pageTitle;

    @FindBy(css = "h4")
    public WebElement subHeader;

    @FindBy(css = "#start button")
    public WebElement startButton;

    @FindBy(css = "#finish h4")
    public WebElement finishedText;

    public DynamicLoadingLoadedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }}
