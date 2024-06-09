package SpringStarts.element;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;


@Slf4j
public class AppiumElement {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    private final By locator;
    private static final Duration DURATION = Duration.ofSeconds(5);

    public AppiumElement(AppiumDriver driver, WebDriverWait wait, By locator) {
        this.driver = driver;
        this.wait = wait;
        this.locator = locator;
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
  /*      appiumDriverUtils.newTouchAction().longPress(longPressOptions().withElement(ElementOption.element(driver.findElement(locator)))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();*/
        log.info("Long press on element: " + locator);

    }

    public void clickOnPastOption() {
        /*var element = driver.findElement(locator);
        var x = element.getLocation().getX() + 30;
        var y = element.getLocation().getY() - 30;
        appiumDriverUtils.newTouchAction().press(PointOption.point(x, y)).release().perform();*/
        log.warn("Long press on element: " + locator);
    }

    public String getAttribute(String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public void waitForElementVisible() {
        waitForElementVisible(DURATION);
    }

    public void waitForElementVisible(Duration duration) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementHasAnyText() {
        wait.until(ExpectedConditions.textMatches(locator, Pattern.compile("^(?!\\s*$).+")));
    }

    public void waitForElementNotVisible() {
        waitForElementNotVisible(DURATION);
    }

    public void waitForElementNotVisible(Duration duration) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementClickable() {
        waitForElementClickable(DURATION);
    }

    public void waitForElementClickable(Duration duration) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}