package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.FormAuthPage;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormAuthTest extends BaseTest {
    String subHeaderText = "This is where you can log into the secure area. Enter tomsmith for " +
            "the username and SuperSecretPassword! for the password. If the information is wrong you " +
            "should see error messages.";
    static FormAuthPage formAuthPage;

    @BeforeAll
    public static void setUp(){
        formAuthPage = new FormAuthPage(driver);
    }

    @BeforeEach
    public void openPage(){
        formAuthPage.openURL();
    }

    @Test
    public void verifyTitleAndSubheader(){
        Assertions.assertEquals("Login Page", formAuthPage.pageTitle.getText());
        Assertions.assertEquals(subHeaderText, formAuthPage.subHeader.getText());
    }

    @Test
    public void enterWrongCredentials(){
        formAuthPage.usernameField.sendKeys("username");
        formAuthPage.passwordField.sendKeys("password");
        formAuthPage.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(formAuthPage.alertBanner));
        Assertions.assertTrue(formAuthPage.alertBanner.getText().contains("Your username is invalid!"));
    }

    @Test
    public void enterCorrectCredentials(){
        formAuthPage.usernameField.sendKeys("tomsmith");
        formAuthPage.passwordField.sendKeys("SuperSecretPassword!");
        formAuthPage.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(formAuthPage.alertBanner));
        Assertions.assertTrue(formAuthPage.alertBanner.getText().contains("You logged into a secure area!"));
        Assertions.assertTrue(formAuthPage.logoutButton.isDisplayed());
    }

    @Test
    public void clickLogout(){
        enterCorrectCredentials();
        formAuthPage.logoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(formAuthPage.alertBanner));
        Assertions.assertTrue(formAuthPage.alertBanner.getText().contains("You logged out of the secure area!"));
    }
}
