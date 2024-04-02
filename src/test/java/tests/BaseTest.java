package tests;

import core.AppiumDriverManager;
import core.helpers.JUnitExtension;
import core.helpers.ShellAdbCommands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(JUnitExtension.class)
public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void createDriver() {
        log.info("Start new test");
        AppiumDriverManager.initDriver();
    }

    @AfterEach
    public void tearDown() {
        var driver = AppiumDriverManager.getDriver();
        if (driver != null) {
            var deviceName = driver.getCapabilities().getCapability("deviceName");
            var appPackage = driver.getCapabilities().getCapability("appPackage");
            ShellAdbCommands.removeApp(deviceName, appPackage);
        }
        AppiumDriverManager.closeDriver();
    }
}
