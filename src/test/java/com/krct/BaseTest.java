package com.krct;

import com.krct.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser =
                ConfigReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        ConfigReader.getTimeout()
                )
        );

        driver.get(
                ConfigReader.getBaseUrl()
        );
    }

    @AfterMethod
    public void tearDown(
            ITestResult result
    ) {

        if (ITestResult.FAILURE ==
                result.getStatus()) {

            takeScreenshot(
                    result.getName()
            );
        }

        if (driver != null) {

            driver.quit();
        }
    }

    public void takeScreenshot(
            String testName
    ) {

        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                ).format(new Date());

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        String path =
                "screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        try {

            FileUtils.copyFile(
                    src,
                    new File(path)
            );

            System.out.println(
                    "Screenshot saved: "
                            + path
            );
        }

        catch (IOException e) {e.printStackTrace();
        }
    }
}