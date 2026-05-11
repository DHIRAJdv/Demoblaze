package com.krct.pages;

import com.krct.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By phones = By.linkText("Phones");
    By laptops = By.linkText("Laptops");
    By home = By.linkText("Home");
    By cart = By.id("cartur");

    public void clickPhones() {
        driver.findElement(phones).click();
    }

    public void clickLaptops() {
        driver.findElement(laptops).click();
    }

    public void clickHome() {
        driver.findElement(home).click();
    }

    public void clickCart() {
        driver.findElement(cart).click();
    }
}