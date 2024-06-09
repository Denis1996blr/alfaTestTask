package SpringStarts;

import SpringStarts.config.ApplicationProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import SpringStarts.scope.AppiumTestScoped;

import java.io.File;
import java.net.URL;

@Slf4j
@Configuration
public class AppiumDriverManager {

    @Autowired
    private ApplicationProperties applicationProperties;

    @SneakyThrows
    @AppiumTestScoped
    @ConditionalOnProperty(name = "appium.platform", havingValue = "android")
    public AppiumDriver androidDriver() {
        var platformName = applicationProperties.getPlatform();
        var appPath = new File(applicationProperties.getApp()).getAbsolutePath();
        var cap = new DesiredCapabilities();

        cap.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability("appium:platformName", platformName);
        cap.setCapability("app", appPath);
        log.info(applicationProperties.getHost());
        return new AndroidDriver(new URL(applicationProperties.getHost()), cap);
    }

    @SneakyThrows
    @AppiumTestScoped
    @ConditionalOnProperty(name = "appium.platform", havingValue = "ios")
    public AppiumDriver iosDriver() {
        throw new RuntimeException("IOS driver isn't supported");
    }
}
