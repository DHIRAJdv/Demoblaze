package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.LoginModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTest extends BaseTest {

    @Test(priority = 1)
    public void existingUserSignupTest() {

        LoginModalPage page =
                new LoginModalPage(driver);

        page.signup("Dhiraj777", "12345678");

        String alert =
                page.getAlertText();

        Assert.assertEquals(
                alert,
                "This user already exist."
        );
    }

    @Test(priority = 2)
    public void emptyLoginTest() {

        LoginModalPage page =
                new LoginModalPage(driver);

        page.login("", "");

        String alert =
                page.getAlertText();

        Assert.assertEquals(
                alert,
                "Please fill out Username and Password."
        );
    }

    @Test(priority = 3)
    public void modalFieldRetainTest() {

        LoginModalPage page =
                new LoginModalPage(driver);

        page.openLoginModal();

        String username = "Dhiraj";

        String password = "12345678";

        driver.findElement(
                org.openqa.selenium.By.id("loginusername")
        ).sendKeys(username);

        driver.findElement(
                org.openqa.selenium.By.id("loginpassword")
        ).sendKeys(password);

        String actualUser =
                driver.findElement(
                        org.openqa.selenium.By.id("loginusername")
                ).getAttribute("value");

        String actualPass =
                driver.findElement(
                        org.openqa.selenium.By.id("loginpassword")
                ).getAttribute("value");

        Assert.assertEquals(
                actualUser,
                username
        );

        Assert.assertEquals(
                actualPass,
                password
        );
    }
}