package tests;

import driverUtils.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    static String browserToUse = System.getProperty("browserName") != null ? System.getProperty("browserName") : BrowserType.CHROME;
    static WebDriver driver;

    static WebDriverWait wait;

    @BeforeAll
    static void beforeEverything(){
        driver = DriverFactory.getBrowser(browserToUse);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    public Select selectDropdown(WebElement element){
        return new Select(element);
    }

    public boolean elementShouldBeVisible(WebElement element, boolean visible){
        boolean flag = false;

        if (visible){
            wait.until(ExpectedConditions.visibilityOf(element));
            flag = true;
        }else {
            try {
                WebDriverWait wait = new WebDriverWait(driver,1);
                wait.until(ExpectedConditions.visibilityOf(element));
            }catch (TimeoutException e){
                flag = true;
            }
        }

        return flag;
    }

    public boolean elementDisplayed(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
