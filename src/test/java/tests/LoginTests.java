package tests;


public class LoginTests {

   /* @Autowired
    public LoginPage loginPage;
    @Autowired
    public AppiumDriverUtils appiumDriverUtils;

    @Test
    @Description("Test to verify success login")
    void successLoginTest() {

        loginPage.verifyTitle();
        //check value by default(equals label(hint))
        var defaultLoginValue = loginPage.getLoginText();
        var defaultPasswordValue = loginPage.getPasswordText();
        assertEquals("Логин", defaultLoginValue);
        assertEquals("Пароль", defaultPasswordValue);

        loginPage.enterLogin("Login");
        loginPage.enterPassword("Password");

        var password = "password";
        var passwordStateBefore = loginPage.getPasswordFieldAttribute(password);
        loginPage.clickOnShowHidePassword();
        var passwordStateAfter = loginPage.getPasswordFieldAttribute(password);
        assertNotEquals(passwordStateBefore, passwordStateAfter);
        loginPage.clickOnShowHidePassword();
        assertEquals(passwordStateBefore, loginPage.getPasswordFieldAttribute(password));

        loginPage.clickLogin();

        var welcomePage = new WelcomePage();
        //welcomePage.verifyLoginResultTitle();
    }

    @Test
    @Description("Test to verify invalid login")
    void failedLoginTest() {
        loginPage.enterLogin("FakeLogin");
        loginPage.enterPassword("FakePassword");
        loginPage.clickLogin();

        var validationMessage = loginPage.getValidationMessage();
        assertEquals("Введены неверные данные", validationMessage);
    }

    @Test
    @Description("Test to verify max number of characters to enter")
    void maxNumberToEnterTest() {
        var loginPage = new LoginPage();

        var outOfRangeLogin = "AZaz.,/'_- LoginLoginLoginLoginLoginLoginLoginLogin"; //51 symbols
        var outOfRangePassword = "AZaz.,/'_- ЛoГinLoginLoginLoginLoginLoginLo!@#%^&*"; //51 symbols
        var maxSize = 50;

        loginPage.enterLogin(outOfRangeLogin);
        loginPage.enterPassword(outOfRangePassword);

        //check that input is cut extra symbols
        var loginValue = loginPage.getLoginText();
        var passwordValue = loginPage.getPasswordText();
        assertEquals(maxSize, loginValue.length());
        assertEquals(maxSize, passwordValue.length());
    }

    @Test
    @Description("Test to verify entering invalid symbols")
    void enteringInvalidSymbolsTest() {
        loginPage.enterLogin("!@#$Login");

        var validationMessage = loginPage.getValidationMessage();
        assertEquals("Введены невалидные символы", validationMessage);
    }

    @Test
    @Description("Test to verify cutting invalid symbols by past option")
    void cuttingInvalidSymbolsTest() {

        var login = "!@#$Login";
        var password = "!@#$Password";
        appiumDriverUtils.setClipboardText(login);
        loginPage.pasteInLoginField();
        appiumDriverUtils.setClipboardText(password);
        loginPage.pasteInPasswordField();

        var loginValue = loginPage.getLoginText();
        var passwordValue = loginPage.getPasswordText();
        assertEquals("Login", loginValue);
        assertEquals(password, passwordValue);

        var validationMessage = loginPage.getValidationMessage();
        assertEquals("Введено все кроме: '!@#$'", validationMessage);
    }*/
}
