package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.CartPage;
import com.krct.pages.ProductDetailPage;
import com.krct.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

//    @Test(priority = 1)
//    public void addProductTest() {
//        ProductDetailPage pd = new ProductDetailPage(driver);
//        CartPage cp = new CartPage(driver);
//        pd.openSamsung();
//        pd.addToCart();
//        cp.acceptAlert();
//        cp.openCart();
//        String cart = cp.getCartText();
//        Assert.assertTrue(cart.contains("samsung"));
//        Assert.assertTrue(cart.contains("360"));
//    }
//
//    @Test(priority = 2)
//    public void addTwoProductsTest() {
//        ProductDetailPage pd = new ProductDetailPage(driver);
//        CartPage cp = new CartPage(driver);
//        pd.openSamsung();
//        pd.addToCart();
//        cp.acceptAlert();
//        driver.navigate().to(ConfigReader.getBaseUrl());
//        pd.clickPhones();
//        pd.openSony();
//        pd.addToCart();
//        cp.acceptAlert();
//        cp.openCart();
//        String cart = cp.getCartText();
//        Assert.assertTrue(cart.contains("samsung"));
//        Assert.assertTrue(cart.contains("sony"));
//    }

    @Test(priority = 3)
    public void deleteProductTest() {
        ProductDetailPage pd = new ProductDetailPage(driver);
        CartPage cp = new CartPage(driver);
        pd.openSamsung();
        pd.addToCart();
        cp.acceptAlert();
        cp.openCart();
        cp.deleteProduct();
        cp.waitForDelete();
        driver.navigate().refresh();
        String cart = cp.getCartText();
        Assert.assertFalse(cart.contains("samsung")
        );
    }

    @Test(priority = 4)
    public void totalPriceTest() {
        ProductDetailPage pd = new ProductDetailPage(driver);
        CartPage cp = new CartPage(driver);
        pd.openSamsung();
        pd.addToCart();
        cp.acceptAlert();
        cp.openCart();
        String beforeDelete = cp.getTotalPrice();
        cp.deleteProduct();
        cp.waitForDelete();
        driver.navigate().refresh();
        String afterDelete = cp.getTotalPrice();
        Assert.assertNotEquals(beforeDelete, afterDelete);
    }
}