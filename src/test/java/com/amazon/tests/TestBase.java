package com.amazon.tests;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class TestBase {


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected  String url;


    @BeforeMethod
    public void setUp() {

        url= ConfigurationReader.get("amazonUrl");
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        actions=new Actions(driver);

        driver.get(url);

        Log.info("Test are starting!");

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException {

          Thread.sleep(2000);
        //  driver.quit();
          Log.info("Quit browser, Success");
    }

    @AfterTest
    public void teardown(){
        BrowserUtils.waitFor(2);
        Log.info("Test are ending!");
        Driver.closeDriver();


    }


}
