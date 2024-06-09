package SpringStarts.element.login;

import SpringStarts.element.AppiumElement;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("ios")
public class IOSLoginElements implements LoginElements{

    @Autowired
    private AppiumDriver driver;

    @Override
    public AppiumElement title() {
        return null;
    }

    @Override
    public AppiumElement loginInput() {
        return null;
    }

    @Override
    public AppiumElement passwordInput() {
        return null;
    }

    @Override
    public AppiumElement loginButton() {
        return null;
    }

    @Override
    public AppiumElement errorMessage() {
        return null;
    }

    @Override
    public AppiumElement showPasswordButton() {
        return null;
    }
}
