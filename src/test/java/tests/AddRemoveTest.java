package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddRemovePage;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddRemoveTest extends BaseTest {

    static AddRemovePage addRemovePage;

    @BeforeAll
    public static void setUp(){
        addRemovePage = new AddRemovePage(driver);
    }

    @BeforeEach
    public void openPage(){
        addRemovePage.openURL();
    }

    @Test
    public void verifyPageDefaults(){
        Assertions.assertEquals("Add/Remove Elements", addRemovePage.pageTitle.getText());
        Assertions.assertTrue(addRemovePage.addButton.isDisplayed());
        Assertions.assertEquals(0, addRemovePage.deleteButton.size());
    }

    @Test
    public void addElementsAndCountThem(){
        Assertions.assertEquals(0, addRemovePage.deleteButton.size());
        addRemovePage.addButton.click();
        Assertions.assertEquals(1, addRemovePage.deleteButton.size());
        addRemovePage.addButton.click();
        Assertions.assertEquals(2, addRemovePage.deleteButton.size());
    }

    @Test
    public void addElementsAndDeleteThem(){
        addElementsAndCountThem();
        addRemovePage.deleteButton.get(0).click();
        Assertions.assertEquals(1, addRemovePage.deleteButton.size());
        addRemovePage.deleteButton.get(0).click();
        Assertions.assertEquals(0, addRemovePage.deleteButton.size());
    }

}
