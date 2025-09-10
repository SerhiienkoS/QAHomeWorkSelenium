package com.ait.HomeWorkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent() {
        return driver.findElements(By.cssSelector("a[href='/register']")).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //--------------------------------------- Add Helpers -------------------------///

    // Click a single element by locator
    protected void click(By locator) {
        driver.findElement(locator).click();   // findElement возвращает один элемент и кликает
    }

    // Type text into an input: clear first, then send keys
    protected void type(By locator, String text) {
        var el = driver.findElement(locator);
        el.clear();       // - clear field
        el.sendKeys();    // - input data
    }

}


