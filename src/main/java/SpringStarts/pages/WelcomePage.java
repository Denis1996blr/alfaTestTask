package SpringStarts.pages;

import SpringStarts.element.AppiumElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomePage {

    @Autowired
    private AppiumDriver driver;

    @Autowired
    private WebDriverWait wait;

    private final AppiumElement loginTitle = new AppiumElement(driver, wait, AppiumBy.className("android.widget.TextView"));

    @Step("Verify success login title")
    public void verifyLoginResultTitle() {
        loginTitle.waitForElementVisible();
    }
}
