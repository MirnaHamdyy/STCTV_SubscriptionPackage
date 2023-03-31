package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ElementFinder {

    public static WebElement findClickableElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement findClickableElement(WebDriver driver, By selector) {
        WebElement element = findAndWaitForElement(driver, selector);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement findAndWaitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void verifyTextInElement(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
