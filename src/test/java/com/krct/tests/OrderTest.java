package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.CartPage;
import com.krct.pages.OrderPage;
import com.krct.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    @Test(priority = 1)
    public void placeOrderTest() {

        ProductDetailPage productPage =
                new ProductDetailPage(driver);

        productPage.openSamsung();

        productPage.addToCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.acceptAlert();

        cartPage.openCart();

        cartPage.waitForCartPage();

        OrderPage orderPage =
                new OrderPage(driver);

        orderPage.clickPlaceOrder();

        orderPage.fillOrderDetails();

        orderPage.clickPurchase();

        String message =
                orderPage.getSuccessMessage();

        Assert.assertTrue(
                message.contains("Thank you")
        );
    }

    @Test(priority = 2)
    public void verifyOrderIdTest() {

        ProductDetailPage productPage =
                new ProductDetailPage(driver);

        productPage.openSamsung();

        productPage.addToCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.acceptAlert();

        cartPage.openCart();

        cartPage.waitForCartPage();

        OrderPage orderPage =
                new OrderPage(driver);

        orderPage.clickPlaceOrder();

        orderPage.fillOrderDetails();

        orderPage.clickPurchase();

        String message =
                orderPage.getSuccessMessage();

        Assert.assertTrue(
                message.contains("Id")
        );
    }

    @Test(priority = 3)
    public void invalidOrderTest() {

        ProductDetailPage productPage =
                new ProductDetailPage(driver);

        productPage.openSamsung();

        productPage.addToCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.acceptAlert();

        cartPage.openCart();

        cartPage.waitForCartPage();

        OrderPage orderPage =
                new OrderPage(driver);

        orderPage.clickPlaceOrder();

        orderPage.fillInvalidDetails();

        orderPage.clickPurchase();

        String alertText =
                cartPage.getAlertText();

        Assert.assertEquals(
                alertText,
                "Please fill out Name and Creditcard."
        );
    }
}