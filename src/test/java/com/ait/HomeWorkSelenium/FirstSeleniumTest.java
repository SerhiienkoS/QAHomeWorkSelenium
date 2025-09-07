package com.ait.HomeWorkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
WebDriver driver;
    //before - setUP
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com"); // without history ( Incognito)
    }
    //test
    @Test
    public void openGoogleTest(){
        System.out.println("Google!!!!");
    }
    //after - tearDown
    @AfterMethod(enabled = true)
    public void tearDown() {
//        driver.quit(); // all tabs and browser (он закрывает все вкладки и браузер)
        driver.close(); // only ona tab (if only one -> close browser) текущая
    }
}
