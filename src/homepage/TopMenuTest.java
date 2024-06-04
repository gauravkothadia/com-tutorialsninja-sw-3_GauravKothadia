package homepage;
/**
 * ● Create the package homepage
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    // 1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//a[normalize-space()='" + menu + "']"));
    }

    // Write the following Test:
    // 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // 1.1 Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        actions.moveToElement(findSingleElement(By.xpath("//a[normalize-space()='Desktops']"))).click().build().perform();
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        // 1.3 Verify the text ‘Desktops’
        Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']")));
    }

    // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        Actions actions = new Actions(driver);
        actions.moveToElement(findSingleElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"))).click().build().perform();
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        // 2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")));
    }

    // 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // 3.1 Mouse hover on “Components” Tab and click
        Actions actions = new Actions(driver);
        actions.moveToElement(findSingleElement(By.xpath("//a[normalize-space()='Components']"))).click().build().perform();
        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        // 3.3 Verify the text ‘Components’
        Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[normalize-space()='Components']")));
    }

    @After
    public void tearDown() {
        //   closeBrowser();
    }
}
