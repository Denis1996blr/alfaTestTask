package tests.tests;

import SpringStarts.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.BaseTest;

public class TestLoginBlock extends BaseTest {

    @Autowired
    public LoginPage loginPage;

    //@Test
    void checkTheUrl3() throws Exception {
        System.out.println("checkTheUrl1() name => " + Thread.currentThread().getName());
        Thread.sleep(1000);
        loginPage.verifyTitle();
        loginPage.enterLogin("Login");
        loginPage.enterPassword("Password");
        Thread.sleep(4000);
    }
}