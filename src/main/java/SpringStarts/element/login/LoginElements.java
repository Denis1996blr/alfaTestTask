package SpringStarts.element.login;

import SpringStarts.element.AppiumElement;

public interface LoginElements {

    AppiumElement title();

    AppiumElement loginInput();

    AppiumElement passwordInput();

    AppiumElement loginButton();

    AppiumElement errorMessage();

    AppiumElement showPasswordButton();
}
