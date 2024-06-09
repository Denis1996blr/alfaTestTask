package SpringStarts.element.login;

import SpringStarts.element.AppiumElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("android")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AndroidLoginElements implements LoginElements {

    @Autowired
    private AppiumDriver driver;

    @Autowired
    private WebDriverWait wait;

    @Override
    public AppiumElement title() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/tvTitle"));
    }

    @Override
    public AppiumElement loginInput() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/etUsername"));
    }

    @Override
    public AppiumElement passwordInput() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/etPassword"));
    }

    @Override
    public AppiumElement loginButton() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/btnConfirm"));
    }

    @Override
    public AppiumElement errorMessage() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/tvError"));
    }

    @Override
    public AppiumElement showPasswordButton() {
        return new AppiumElement(driver, wait, AppiumBy.id("com.alfabank.qapp:id/text_input_end_icon"));
    }
}
