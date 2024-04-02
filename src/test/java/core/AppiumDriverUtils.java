package core;

import config.AppConfig;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;

import static config.Platform.android;

public class AppiumDriverUtils {

    private static final AppConfig APP_CONFIG = ConfigFactory.create(AppConfig.class);

    public static void setClipboardText(String text) {
        var driver = AppiumDriverManager.getDriver();
        if (APP_CONFIG.platformName().equals(android)) {
            ((AndroidDriver) driver).setClipboardText(text);
        } else {
            ((IOSDriver) driver).setClipboardText(text);
        }
    }

    public static TouchAction newTouchAction() {
        var driver = AppiumDriverManager.getDriver();
        TouchAction action;
        if (APP_CONFIG.platformName().equals(android)) {
            action = new TouchAction((AndroidDriver) driver);
        } else {
            action = new TouchAction((IOSDriver) driver);
        }
        return action;
    }
}
