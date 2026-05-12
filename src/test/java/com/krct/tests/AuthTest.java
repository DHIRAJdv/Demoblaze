package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.LoginModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    String username = "Dhiraj753159";
    String password = "12345678";

    @Test(priority = 1)
    public void signupTest() {
        LoginModalPage page = new LoginModalPage(driver);
        page.signup(username, password);
        String actual = page.getAlertText();
        String expected = "Sign up successful.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void loginTest() {
        LoginModalPage page = new LoginModalPage(driver);
        page.login(username, password);
        String actual = page.getWelcomeText();
        String expected = "Welcome " + username;
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void invalidLoginTest() {
        LoginModalPage page = new LoginModalPage(driver);
        page.login("wrong", password);
        String actual = page.getAlertText();
        String expected = "Wrong password.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 4)
    public void logoutTest() {
        LoginModalPage page = new LoginModalPage(driver);
        page.login(username, password);
        page.logout();
        String actual = page.getLoginText();
        String expected = "Log in";
        Assert.assertEquals(actual, expected);
    }
}