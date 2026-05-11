package com.krct.pages;
import com.krct.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By placeOrder = By.xpath("//button[text()='Place Order']");

    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By card = By.id("card");
    By month = By.id("month");
    By year = By.id("year");

    By purchase = By.xpath("//button[text()='Purchase']");

    By successMessage = By.className("sweet-alert");

    public void clickPlaceOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));

        driver.findElement(placeOrder).click();
    }

    public void fillOrderDetails() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(name));

        driver.findElement(name).sendKeys("Dhiraj");

        driver.findElement(country).sendKeys("India");

        driver.findElement(city).sendKeys("Trichy");

        driver.findElement(card).sendKeys("123456789");

        driver.findElement(month).sendKeys("May");

        driver.findElement(year).sendKeys("2026");
    }

    public void clickPurchase() {

        driver.findElement(purchase).click();
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        return driver.findElement(successMessage).getText();
    }

    public void fillInvalidDetails() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(name));

        driver.findElement(country).sendKeys("India");

        driver.findElement(city).sendKeys("Trichy");

        driver.findElement(month).sendKeys("May");

        driver.findElement(year).sendKeys("2026");
    }
}
