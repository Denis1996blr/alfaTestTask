package core;

import config.AppConfig;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppiumDriverManager {

    private static final AppConfig APP_CONFIG = ConfigFactory.create(AppConfig.class);
    private static final ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(AppiumDriverManager.class);

    public static AppiumDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void initDriver() {
        var platformName = APP_CONFIG.platformName();

        switch (platformName) {
            case android:
                var driver = new AndroidDriverFactory().getDriver(APP_CONFIG);
                threadLocalDriver.set(driver);
                log.info("android driver was created");
                break;
            default:
                throw new RuntimeException(String.format("Current driver '%s' isn't supported", platformName));
        }
    }

    public static void closeDriver() {
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
        log.info("Appium driver was closed");
    }
}
