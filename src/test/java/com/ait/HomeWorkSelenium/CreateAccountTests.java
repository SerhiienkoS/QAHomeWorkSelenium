package com.ait.HomeWorkSelenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        //click on Register link
        driver.findElement(By.cssSelector("a.ico-register")).click();

        //Enter First name:
        driver.findElement(By.xpath("//input[@id='FirstName']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Sergey");

        //Enter Last name:
        driver.findElement(By.xpath("//input[@id='LastName']")).click();
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Tester" + i);

        //Enter Email:
        String email = "Sergey" + 1 + "@gmail.com";
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);

        //Enter Password:
        String password = "Password123!";
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);
        //Enter Confirm password:
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        //click on Registration button
        driver.findElement(By.id("register-button")).click();

        //check "Log out" (After successful registration, a “Log out” link appears.)
        boolean loggedIn = driver.findElements(By.cssSelector(".header-links a[href='/logout']")).size() > 0;
        if (loggedIn) {
            System.out.println("Registration successful ✅ (Logout visible)");
        } else {
            System.out.println("Registration unsuccessful ❌");
        }
    }

    @Test
    public void loginNegativeWrongPasswordTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("user" + i + "@example.com");

        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("WrongPass123!");

        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        boolean hasError = driver.findElements(By.cssSelector(".message-error")).size() > 0;

        if (hasError) {
            System.out.println("Negative login behaves correctly ✅ (error message is displayed)");
        } else {
            System.out.println("Negative login did not trigger an error ❌ (no error message found)");
        }
    }

    @Test
    public void loginPositiveTest() {
        String testEmail = "Sergey" + 1 + "@gmail.com";
        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(testEmail);

        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Password123!");

        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        boolean loggedIn = driver.findElements(By.cssSelector(".header-links a[href='/logout']")).size() > 0;

        if (loggedIn) {
            System.out.println("Positive login successful ✅ (Logout link is visible)");
        } else {
            System.out.println("Positive login failed ❌ (Logout link is not visible)");
        }
    }

}

