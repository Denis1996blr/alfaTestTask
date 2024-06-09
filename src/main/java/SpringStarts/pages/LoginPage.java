package SpringStarts.pages;

import SpringStarts.element.login.LoginElements;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginPage extends BasePage {

    @Autowired
    private LoginElements loginElements;




    @Step("Enter text in login input")
    public void enterLogin(String login) {
        loginElements.loginInput().waitForElementClickable();
        loginElements.loginInput().sendText(login);
    }

    @Step("Enter text in password input")
    public void enterPassword(String password) {
        loginElements.passwordInput().waitForElementClickable();
        loginElements.passwordInput().sendText(password);
    }

    @Step("Click on login button")
    public void clickLogin() {
        loginElements.loginButton().waitForElementClickable();
        loginElements.loginButton().click();
    }

    @Step("Get validation message")
    public String getValidationMessage() {
        loginElements.errorMessage().waitForElementVisible();
        loginElements.errorMessage().waitForElementHasAnyText();
        return loginElements.errorMessage().getText();
    }

    @Step("Get value of login input")
    public String getLoginText() {
        loginElements.loginInput().waitForElementVisible();
        return loginElements.loginInput().getText();
    }

    @Step("Get value of password input")
    public String getPasswordText() {
        loginElements.passwordInput().waitForElementVisible();
        return loginElements.passwordInput().getText();
    }

    @Step("Get 'password' attribute for password field")
    public String getPasswordFieldAttribute(String attribute) {
        return loginElements.passwordInput().getAttribute(attribute);
    }

    @Step("Click on show/hide password button")
    public void clickOnShowHidePassword() {
        loginElements.showPasswordButton().waitForElementClickable();
        loginElements.showPasswordButton().click();
    }

    @Step("Verify title")
    public void verifyTitle() {
        loginElements.title().waitForElementVisible();
    }

    @Step("Paste value in login field")
    public void pasteInLoginField() {
        loginElements.passwordInput().waitForElementClickable();
        loginElements.loginInput().longPress();
        //TODO: flaky place. to discuss
        loginElements.loginInput().clickOnPastOption();
    }

    @Step("Paste value in password field")
    public void pasteInPasswordField() {
        loginElements.passwordInput().waitForElementClickable();
        loginElements.passwordInput().longPress();
        //TODO: flaky place. to discuss
        loginElements.passwordInput().clickOnPastOption();
    }
}