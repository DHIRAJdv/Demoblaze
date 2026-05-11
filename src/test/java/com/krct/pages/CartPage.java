package com.krct.pages;

import com.krct.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

        super(driver);
    }

    By cartBtn = By.id("cartur");

    By deleteBtn = By.linkText("Delete");

    By totalPrice = By.id("totalp");

    By cartBody = By.xpath("//tbody");

    public void openCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cartBtn
                )
        );

        driver.findElement(cartBtn).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBody
                )
        );
    }

    public void waitForCartPage() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBody
                )
        );
    }

    public String getCartText() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBody
                )
        );

        return driver.findElement(cartBody)
                .getText()
                .toLowerCase();
    }

    public void deleteProduct() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        deleteBtn
                )
        );

        driver.findElement(deleteBtn).click();
    }

    public void waitForDelete() {

        wait.until(driver ->

                !driver.findElement(cartBody)
                        .getText()
                        .toLowerCase()
                        .contains("samsung")

        );
    }

    public String getTotalPrice() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            totalPrice
                    )
            );

            return driver.findElement(totalPrice)
                    .getText()
                    .trim();
        }

        catch (Exception e) {

            return "";
        }
    }

    public void acceptAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert a =
                driver.switchTo().alert();

        a.accept();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("nava")
                )
        );
    }

    public String getAlertText() {

        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        Alert a =
                driver.switchTo().alert();

        String text =
                a.getText();

        a.accept();

        return text;
    }
}