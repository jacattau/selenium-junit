package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemovePage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "h3")
    public WebElement pageTitle;

    @FindBy(css = "button[onclick='addElement()']")
    public WebElement addButton;

    @FindBy(css = "button[onclick='deleteElement()']")
    public List<WebElement> deleteButton;

    @FindBy(css = "button[onclick='secretElement()']")
    public WebElement secretButton;

    public AddRemovePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(){
        driver.get(baseUrl + "/add_remove_elements/");
    }
}
