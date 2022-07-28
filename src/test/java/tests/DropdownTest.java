package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DropdownTest extends BaseTest {

    static DropdownPage dropdownPage;

    @BeforeAll
    public static void setUp(){
        dropdownPage = new DropdownPage(driver);
    }

    @BeforeEach
    public void openPage(){
        dropdownPage.openURL();
    }

    @Test
    public void verifyPageDefaults(){
        Assertions.assertEquals("Dropdown List", dropdownPage.pageTitle.getText());
        Assertions.assertTrue(dropdownPage.dropdown.isDisplayed());
        Assertions.assertEquals("Please select an option",selectDropdown(dropdownPage.dropdown).getFirstSelectedOption().getText());
    }

    @Test
    public void selectBothOptionsInDropdown(){
        selectDropdown(dropdownPage.dropdown).selectByVisibleText("Option 1");
        Assertions.assertEquals("Option 1",selectDropdown(dropdownPage.dropdown).getFirstSelectedOption().getText());
        selectDropdown(dropdownPage.dropdown).selectByIndex(2);
        Assertions.assertEquals("Option 2",selectDropdown(dropdownPage.dropdown).getFirstSelectedOption().getText());
    }
}
