package SpringStarts.core;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.springframework.beans.factory.annotation.Autowired;


public class AppiumDriverUtils {

/*    @Autowired
    private AppiumDriver driver;

    @Autowired
    private ApplicationProperties applicationProperties;


    public void setClipboardText(String text) {
        if (applicationProperties.getPlatform().equals(Platform.android)) {
            ((AndroidDriver) driver).setClipboardText(text);
        } else {
            ((IOSDriver) driver).setClipboardText(text);
        }
    }

    public TouchAction newTouchAction() {
        TouchAction action;
        if (applicationProperties.getPlatform().equals(Platform.android)) {
            action = new TouchAction((AndroidDriver) driver);
        } else {
            action = new TouchAction((IOSDriver) driver);
        }
        return action;
    }*/
}
