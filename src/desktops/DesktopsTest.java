package desktops;
/**
 * ● Create the package name desktops
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */

import com.beust.ah.A;
import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // Write the following Test:
    // 1.Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        actions.moveToElement(findSingleElement(By.xpath("//a[normalize-space()='Desktops']"))).click().build().perform();
        // 1.2 Click on “Show All Desktops”
        TopMenuTest t = new TopMenuTest();
        t.selectMenu("Show AllDesktops");
        // 1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        // 1.4 Verify the Product will arrange in Descending order.
        List<WebElement> listOfProducts = findMultipleElements(By.cssSelector("div.caption>h4>a"));
        List<String> productList = new ArrayList<>();
        for (WebElement ele : listOfProducts) {
            productList.add(ele.getText());
        }
        // Creating a replica of original list and sorting in reverse order using collections
        List<String> sotredNames = productList;
        Collections.sort(sotredNames, Collections.reverseOrder());
        Assert.assertEquals(sotredNames, productList);
    }


    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Currency Dropdown and click
        // 2.2 Mouse hover on £Pound Sterling and click
        Actions actions = new Actions(driver);
        actions.moveToElement(findSingleElement(By.xpath("//div[@class='btn-group']//button[@class='btn btn-link dropdown-toggle']"))).click()
                .moveToElement(findSingleElement(By.xpath("//button[normalize-space()='£Pound Sterling']"))).click().build().perform();
        // 2.3 Mouse hover on Desktops Tab.
        actions.moveToElement(findSingleElement(By.xpath("//a[normalize-space()='Desktops']"))).click().build().perform();
        // 2.4 Click on “Show All Desktops”
        TopMenuTest t = new TopMenuTest();
        t.selectMenu("Show AllDesktops");
        // 2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        // 2.6 Select product “HP LP3065”
        List<WebElement> listOfProducts = findMultipleElements(By.cssSelector("div.caption>h4>a"));
        for (WebElement ele : listOfProducts) {
            if (ele.getText().equals("HP LP3065")) {
                clickOnWebElement(ele);
                break;
            }
        }
        // 2.7 Verify the Text "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));
        // 2.8 Select Delivery Date "2023-11-27"
        ///clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']"));
        //selectDate("2023","November","27");
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Open the calendar
        while (true) {
            String monthAndYear = getTextFromElement(By.xpath("//div[@class='datepicker-days']//thead//tr[1]"));
            String[] a = monthAndYear.split(" ");
            String mon = a[1];
            String yer = a[2];
            if (mon.equals(month) && yer.equals(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));

            }
        }
        // 2.9.Enter Qty "1” using Select class.
        findSingleElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        // 2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).contains("Success: You have added HP LP3065 to your shopping cart!"));
        // 2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.13 Verify the text "Shopping Cart"
        Assert.assertTrue(getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).contains("Shopping Cart"));
        // 2.14 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065",getTextFromElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]")));
        // 2.15 Verify the Delivery Date "2023-11-27"
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class='table-responsive']//small[contains(text(),'Delivery Date')]")).contains("2023-11-27"));
        // 2.16 Verify the Model "Product21"
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class='table-responsive']//small[contains(text(),'Delivery Date')]/parent::td/following-sibling::td[1]")).contains("Product 21"));
        // 2.17 Verify the Todat "£74.73"
        Assert.assertEquals("£74.73",getTextFromElement(By.xpath("//strong[normalize-space()='Total:']/parent::td/following-sibling::td")));
    }

    @After
    public void tearDown() {
        //   closeBrowser();
    }
}
