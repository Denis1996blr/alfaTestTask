package core.helpers;

import core.AppiumDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class JUnitExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        if (extensionContext.getExecutionException().isPresent()) {
            Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
                    ((TakesScreenshot) AppiumDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES));
        }
    }
}
