package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class BrowserUtilities extends DriverUtilities {

    private WebDriverWait explicitWait;
    public static DriverUtilities driverUtilities;
    public static WebDriver driver;

    public void setExplicitWait(long seconds) {
        this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    // Implicit Wait
    public static void implicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // alertIsPresent()
    public void waitForAlertIsPresent() {
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    // elementToBeClickable()
    public void waitForElementToBeClickable(WebElement element) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // elementToBeSelected()
    public void waitForElementToBeSelected(WebElement element) {
        explicitWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    // textToBePresentInElement()
    public void waitForTextToBePresentInElement(WebElement element, String text) {
        explicitWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // elementSelectionStateToBe()
    public void waitForElementSelectionStateToBe(WebElement element, boolean selected) {
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(String frameLocator) {
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    // invisibilityOfTheElementLocated()
    public void waitForInvisibilityOfTheElementLocated(By locator) {
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // invisibilityOfElementWithText()
    public void waitForInvisibilityOfElementWithText(By locator, String text) {
        explicitWait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    // presenceOfAllElementsLocatedBy()
    public void waitForPresenceOfAllElementsLocatedBy(By locator) {
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    // presenceOfElementLocated()
    public void waitForPresenceOfElementLocated(By locator) {
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // textToBePresentInElementLocated()
    public void waitForTextToBePresentInElementLocated(By locator, String text) {
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // textToBePresentInElementValue()
    public void waitForTextToBePresentInElementValue(WebElement element, String text) {
        explicitWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    // titleIs()
    public void waitForTitleIs(String title) {
        explicitWait.until(ExpectedConditions.titleIs(title));
    }

    // titleContains()
    public void waitForTitleContains(String title) {
        explicitWait.until(ExpectedConditions.titleContains(title));
    }

    // visibilityOf()
    public void waitForVisibilityOf(WebElement element) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    // visibilityOfAllElements()
    public void waitForVisibilityOfAllElements(List<WebElement> elements) {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // visibilityOfAllElementsLocatedBy()
    public void waitForVisibilityOfAllElementsLocatedBy(By locator) {
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // visibilityOfElementLocated()
    public void waitForVisibilityOfElementLocated(By locator) {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Fluent Wait visibilityOf()
    public void fluentWaitForVisibilityOf(long seconds, long pollingSeconds, WebElement element) {
        Wait<WebDriver> fluentWait;
        try {
            fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds)).pollingEvery(Duration.ofSeconds(pollingSeconds)).ignoring(NoSuchElementException.class);
            fluentWait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Javascript Executor
    public void javascriptExecuteScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void javascriptExecuteScript(String script, Object arg) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, arg);
    }

    public void javascriptExecuteScript(String script, Objects args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }

    public void javascriptExecuteAsyncScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(script);
    }

    public void javascriptExecuteAsyncScript(String script, Object arg) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(script, arg);
    }

    // change Windows
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public Set<String> getAllOpenWindowHandles() {
        return driver.getWindowHandles();
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void changeToOriginalWindow() {
        driver.switchTo().window(getCurrentWindowHandle());
    }

    public void closeWindowOrTab() {
        driver.close();
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void minimizeWindow() {
        driver.manage().window().minimize();
    }

    // navigation
    public void driverGet(String url) {
        driver.get(url);
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void navigateBackward() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    // Screenshot
    public void screenShot(String fileLocation) {
        try {
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenShotFile, new File(fileLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCssValue(WebElement element, String propertyName) {
        setExplicitWait(10);
        waitForVisibilityOf(element);
        return element.getCssValue(propertyName);
    }

    //Screenshot
    public static void screenShot(String fileLocation, String method) {
        try {
            String screenShotPath = fileLocation + method + ".png";
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenShotFile, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
