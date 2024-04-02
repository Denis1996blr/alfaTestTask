package pages;

import core.element.AppiumElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class LoginPage {

    private final AppiumElement loginInput = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/etUsername"));
    private final AppiumElement passwordInput = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/etPassword"));
    private final AppiumElement loginButton = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/btnConfirm"));
    private final AppiumElement errorMessage = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/tvError"));
    private final AppiumElement showPasswordButton = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/text_input_end_icon"));
    private final AppiumElement title = new AppiumElement(AppiumBy.id("com.alfabank.qapp:id/tvTitle"));


    @Step("Enter text in login input")
    public void enterLogin(String login) {
        loginInput.waitForElementClickable();
        loginInput.sendText(login);
    }

    @Step("Enter text in password input")
    public void enterPassword(String password) {
        passwordInput.waitForElementClickable();
        passwordInput.sendText(password);
    }

    @Step("Click on login button")
    public void clickLogin() {
        loginButton.waitForElementClickable();
        loginButton.click();
    }

    @Step("Get validation message")
    public String getValidationMessage() {
        errorMessage.waitForElementVisible();
        errorMessage.waitForElementHasAnyText();
        return errorMessage.getText();
    }

    @Step("Get value of login input")
    public String getLoginText() {
        loginInput.waitForElementVisible();
        return loginInput.getText();
    }

    @Step("Get value of password input")
    public String getPasswordText() {
        passwordInput.waitForElementVisible();
        return passwordInput.getText();
    }

    @Step("Get 'password' attribute for password field")
    public String getPasswordFieldAttribute(String attribute) {
        return passwordInput.getAttribute(attribute);
    }

    @Step("Click on show/hide password button")
    public void clickOnShowHidePassword() {
        showPasswordButton.waitForElementClickable();
        showPasswordButton.click();
    }

    @Step("Verify title")
    public void verifyTitle() {
        title.waitForElementVisible();
    }


    @Step("Paste value in login field")
    public void pasteInLoginField() {
        passwordInput.waitForElementClickable();
        loginInput.longPress();
        //TODO: flaky place. to discuss
        loginInput.clickOnPastOption();
    }

    @Step("Paste value in password field")
    public void pasteInPasswordField() {
        passwordInput.waitForElementClickable();
        passwordInput.longPress();
        //TODO: flaky place. to discuss
        passwordInput.clickOnPastOption();
    }
}