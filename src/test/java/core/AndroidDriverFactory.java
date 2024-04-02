package core;

import config.AppConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverFactory {

    public AndroidDriver getDriver(AppConfig appConfig) {

        var cap = new DesiredCapabilities();
        var file = new File(appConfig.app());

        cap.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability("appium:platformName", appConfig.platformName());
        cap.setCapability("app", file.getAbsolutePath());

        try {
            return new AndroidDriver(new URL(appConfig.remote()), cap);
        } catch (MalformedURLException exception) {
            throw new RuntimeException(String.format("Appium server '%s' isn't available.", appConfig.remote()));
        }
    }
}
