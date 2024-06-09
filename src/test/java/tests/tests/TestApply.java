package tests.tests;

import SpringStarts.MyClass;
import SpringStarts.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import tests.BaseTest;
import tests.helpers.ShellAdbCommands;

public class TestApply extends BaseTest {

    //@Autowired
    //public LoginPage loginPage;

    @Test
    void checkTheUrl1() throws Exception {
        System.out.println("checkTheUrl1() name => " + Thread.currentThread().getName() + " Current session is " + driver.getSessionId());
        Thread.sleep(10000);

        //loginPage.verifyTitle();
        //loginPage.enterLogin("Login");
        //loginPage.enterPassword("Password");


    }

    @Test
    void checkTheUrl2() throws Exception {
        System.out.println("checkTheUrl2() name => " + Thread.currentThread().getName() + " Current session is " + driver.getSessionId());

        Thread.sleep(5000);
        //loginPage.verifyTitle();
        //loginPage.enterLogin("Login");
        //loginPage.enterPassword("Password");


    }
}
