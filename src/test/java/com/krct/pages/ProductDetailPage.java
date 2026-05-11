package com.krct.pages;

import com.krct.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By phones = By.linkText("Phones");
    By laptops = By.linkText("Laptops");
    By home = By.id("nava");
    By firstProduct = By.className("hrefch");
    By productName = By.className("name");
    By productPrice = By.className("price-container");
    By productDescription = By.id("more-information");
    By addCart = By.linkText("Add to cart");

    public void clickPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(phones));
        driver.findElement(phones).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
    }

    public void clickLaptops() {
        wait.until(ExpectedConditions.elementToBeClickable(laptops));
        driver.findElement(laptops).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
    }

    public boolean isProductDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        return driver.findElement(firstProduct).isDisplayed();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        driver.findElement(firstProduct).click();
    }

    public boolean isProductDetailsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        boolean name = driver.findElement(productName).isDisplayed();
        boolean price = driver.findElement(productPrice).isDisplayed();
        boolean description = driver.findElement(productDescription).isDisplayed();
        return name && price && description;
    }

    public void clickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(home));
        driver.findElement(home).click();
    }

    public boolean isHomePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        return driver.findElement(firstProduct).isDisplayed();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addCart));
        driver.findElement(addCart).click();
    }

    public void openSamsung() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
    }

    public void openSony() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sony vaio i5")));
        driver.findElement(By.linkText("Sony vaio i5")).click();
    }
}