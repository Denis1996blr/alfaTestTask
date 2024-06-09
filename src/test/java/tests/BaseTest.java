package tests;

import SpringStarts.MyClass;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import tests.helpers.JUnitExtension;
import tests.helpers.ShellAdbCommands;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@ExtendWith(JUnitExtension.class)
@Slf4j
@SpringBootTest(classes = MyClass.class)
public class BaseTest {

    @Autowired
    public ApplicationContext applicationContext;


    @Autowired
    public AppiumDriver driver;

    @BeforeEach
    public void createDriver() {
        log.info("Start new test");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            var deviceName = driver.getCapabilities().getCapability("deviceName");
            var appPackage = driver.getCapabilities().getCapability("appPackage");
            ShellAdbCommands.removeApp(deviceName, appPackage);
            this.applicationContext
                    .getBean(AppiumDriver.class)
                    .quit();
        }
    }
}
