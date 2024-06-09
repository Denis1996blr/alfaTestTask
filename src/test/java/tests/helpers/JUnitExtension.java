package tests.helpers;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Configuration
public class JUnitExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        var ctx = SpringExtension.getApplicationContext(extensionContext);
        var driver = ctx.getBean(AppiumDriver.class);
        if (extensionContext.getExecutionException().isPresent()) {
            Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
