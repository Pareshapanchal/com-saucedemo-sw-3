package utitilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    // This method will click on elements
     public void clickOnElement(By by){
        driver.findElement(by).click();
     }
    //This method will send text to the element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
     }
    //This method will get the text from the element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public int getTheNumberOfElementOnTheList(By by){
        return driver.findElements(by).size();
     }
}
