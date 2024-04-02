package core.element;

import core.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.regex.Pattern;

import static core.AppiumDriverUtils.*;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class AppiumElement {

    private static final Duration DURATION = Duration.ofSeconds(5);
    private static final Logger log = LogManager.getLogger(AppiumElement.class);
    private final By locator;
    private final AppiumDriver driver;


    public AppiumElement(By locator) {
        this.locator = locator;
        this.driver = AppiumDriverManager.getDriver();
    }

    public void sendText(String text) {
        driver.findElement(locator).sendKeys(text);
        log.info(String.format("Send text='%s' to element '%s'", text, locator));
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

    public boolean isClickable() {
        isVisible();
        return driver.findElement(locator).isEnabled();
    }

    public boolean isVisible() {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void click() {
        driver.findElement(locator).click();
        log.info("Click on element: " + locator);

    }

    public void longPress() {
        newTouchAction().longPress(longPressOptions().withElement(ElementOption.element(driver.findElement(locator)))
                .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();
        log.info("Long press on element: " + locator);

    }

    public void clickOnPastOption() {
        var element = driver.findElement(locator);
        var x = element.getLocation().getX() + 30;
        var y = element.getLocation().getY() - 30;
        newTouchAction().press(PointOption.point(x, y)).release().perform();
        log.warn("Long press on element: " + locator);
    }

    public String getAttribute(String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public void waitForElementVisible() {
        waitForElementVisible(DURATION);
    }

    public void waitForElementVisible(Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementHasAnyText() {
        new WebDriverWait(driver, DURATION).until(ExpectedConditions.textMatches(locator, Pattern.compile("^(?!\\s*$).+")));
    }

    public void waitForElementNotVisible() {
        waitForElementNotVisible(DURATION);
    }

    public void waitForElementNotVisible(Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementClickable() {
        waitForElementClickable(DURATION);
    }

    public void waitForElementClickable(Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator));
    }
}