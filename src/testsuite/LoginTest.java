package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utitilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
     public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    // public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
   //public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userSholdLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id ='login-button']"));
        //Verify the text “PRODUCTS”
        String actualProductsDisplay = getTextFromElement(By.xpath("//span[@class='title']"));
        String expectedProductsDisplay ="Products";
        Assert.assertEquals("Title is not matching",expectedProductsDisplay,actualProductsDisplay);
    }
    @Test
    //2. verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id ='login-button']"));
        //Verify that six products are displayed on page
        int numberOfProduct = getTheNumberOfElementOnTheList(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals("Total number of products displayed on the page is incorrect",6,numberOfProduct);
    }
    //cloing browser
    @After
    public void tearDown(){closeBrowser();}
}
