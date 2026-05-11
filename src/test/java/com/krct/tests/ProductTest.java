package com.krct.tests;

import com.krct.BaseTest;
import com.krct.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(priority = 1)
    public void phonesCategoryTest() {
        ProductDetailPage page = new ProductDetailPage(driver);
        page.clickPhones();
        Assert.assertTrue(page.isProductDisplayed());
    }

    @Test(priority = 2)
    public void laptopsCategoryTest() {
        ProductDetailPage page = new ProductDetailPage(driver);
        page.clickLaptops();
        Assert.assertTrue(page.isProductDisplayed());
    }

    @Test(priority = 3)
    public void productDetailsTest() {
        ProductDetailPage page = new ProductDetailPage(driver);
        page.clickFirstProduct();
        Assert.assertTrue(page.isProductDetailsDisplayed());
    }

    @Test(priority = 4)
    public void homeButtonTest() {
        ProductDetailPage page = new ProductDetailPage(driver);
        page.clickHome();
        Assert.assertTrue(page.isHomePageDisplayed());
    }
}