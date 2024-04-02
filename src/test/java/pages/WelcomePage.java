package pages;

import core.element.AppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class WelcomePage {

    private final AppiumElement loginTitle = new AppiumElement(AppiumBy.className("android.widget.TextView"));

    @Step("Verify success login title")
    public void verifyLoginResultTitle() {
        loginTitle.waitForElementVisible();
    }
}
