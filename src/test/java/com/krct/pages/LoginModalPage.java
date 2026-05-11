package com.krct.pages;

import com.krct.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModalPage extends BasePage {

    WebDriver driver;

    public LoginModalPage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    By signup = By.id("signin2");

    By signupUser = By.id("sign-username");

    By signupPass = By.id("sign-password");

    By signupBtn = By.xpath("//button[text()='Sign up']");

    By login = By.id("login2");

    By loginUser = By.id("loginusername");

    By loginPass = By.id("loginpassword");

    By loginBtn = By.xpath("//button[text()='Log in']");

    By welcome = By.id("nameofuser");

    By logout = By.id("logout2");

    public void signup(String username, String password) {

        driver.findElement(signup).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signupUser
                )
        );

        driver.findElement(signupUser).clear();

        driver.findElement(signupUser).sendKeys(username);

        driver.findElement(signupPass).clear();

        driver.findElement(signupPass).sendKeys(password);

        driver.findElement(signupBtn).click();
    }

    public String getAlertText() {

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();

        alert.accept();

        return text;
    }

    public void openLoginModal() {

        driver.findElement(login).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginUser
                )
        );
    }

    public void login(String username, String password) {

        openLoginModal();

        driver.findElement(loginUser).clear();

        driver.findElement(loginUser).sendKeys(username);

        driver.findElement(loginPass).clear();

        driver.findElement(loginPass).sendKeys(password);

        driver.findElement(loginBtn).click();
    }

    public String getWelcomeText() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        welcome
                )
        );

        return driver.findElement(welcome).getText();
    }

    public void logout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        logout
                )
        );

        driver.findElement(logout).click();
    }

    public String getLoginText() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        login
                )
        );

        return driver.findElement(login).getText();
    }
}