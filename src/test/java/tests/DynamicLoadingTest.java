package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DynamicLoadingLoadedPage;
import pages.DynamicLoadingPage;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicLoadingTest extends BaseTest {
    String topSubheaderText = "It's common to see an action get triggered that returns a result dynamically. " +
            "It does not rely on the page to reload or finish loading. The page automatically gets updated " +
            "(e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.";
    String bottomSubheaderText = "There are two examples. One in which an element already exists on the page but it" +
            " is not displayed. And anonther where the element is not on the page and gets added in.";

    static DynamicLoadingPage dynamicLoadingPage;
    static DynamicLoadingLoadedPage dynamicLoadingLoadedPage;

    @BeforeAll
    public static void setUp(){
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @BeforeEach
    public void openPage(){
        dynamicLoadingPage.openURL();
    }

    @Test
    public void verifyPageDefaults(){
        Assertions.assertEquals("Dynamically Loaded Page Elements", dynamicLoadingPage.pageTitle.getText());
        Assertions.assertEquals(topSubheaderText, dynamicLoadingPage.subHeaderTop.getText());
        Assertions.assertEquals(bottomSubheaderText, dynamicLoadingPage.subHeaderBottom.getText());
        Assertions.assertTrue(dynamicLoadingPage.example1Link.isDisplayed());
        Assertions.assertTrue(dynamicLoadingPage.example2Link.isDisplayed());
    }

    @Test
    public void clickExample1LinkAndTestFeature(){
        dynamicLoadingPage.example1Link.click();
        dynamicLoadingLoadedPage = new DynamicLoadingLoadedPage(driver);
        Assertions.assertEquals("Dynamically Loaded Page Elements", dynamicLoadingLoadedPage.pageTitle.getText());
        Assertions.assertEquals("Example 1: Element on page that is hidden", dynamicLoadingLoadedPage.subHeader.getText());
        Assertions.assertTrue(elementShouldBeVisible(dynamicLoadingLoadedPage.finishedText,false));
        dynamicLoadingLoadedPage.startButton.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingLoadedPage.finishedText));
        Assertions.assertEquals("Hello World!", dynamicLoadingLoadedPage.finishedText.getText());
    }

    @Test
    public void clickExample2LinkAndTestFeature(){
        dynamicLoadingPage.example2Link.click();
        dynamicLoadingLoadedPage = new DynamicLoadingLoadedPage(driver);
        Assertions.assertEquals("Dynamically Loaded Page Elements", dynamicLoadingLoadedPage.pageTitle.getText());
        Assertions.assertEquals("Example 2: Element rendered after the fact", dynamicLoadingLoadedPage.subHeader.getText());
        Assertions.assertFalse(elementDisplayed(dynamicLoadingLoadedPage.finishedText));
        dynamicLoadingLoadedPage.startButton.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingLoadedPage.finishedText));
        Assertions.assertEquals("Hello World!", dynamicLoadingLoadedPage.finishedText.getText());
    }
}
