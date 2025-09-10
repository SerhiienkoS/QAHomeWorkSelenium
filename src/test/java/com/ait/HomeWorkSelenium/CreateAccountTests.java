package com.ait.HomeWorkSelenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = true)
    public void newUserRegistrationPositiveTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        // open Register page
        click(By.cssSelector("a.ico-register"));

        // fill form
        type(By.id("FirstName"), "Sergey");
        type(By.id("LastName"), "Tester" + i);

        String email = "Sergey" + i + "@gmail.com";
        String password = "Password123!";

        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);

        // submit
        click(By.id("register-button"));

        // check: Logout visible
        boolean loggedIn = isElementPresent(By.cssSelector(".header-links a[href='/logout']"));
        System.out.println(loggedIn
                ? "Registration successful ✅ (Logout visible)"
                : "Registration unsuccessful ❌");
    }

    @Test
    public void loginNegativeWrongPasswordTest() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        click(By.cssSelector("a.ico-login"));

        // enter fake creds
        type(By.id("Email"), "user" + i + "@example.com");
        type(By.id("Password"), "WrongPass123!");

        // submit
        click(By.cssSelector("input.button-1.login-button"));

        // expect error

        boolean hasError = isElementPresent(By.cssSelector(".message-error"));
        System.out.println(hasError
                ? "Negative login behaves correctly ✅ (error message is displayed)"
                : "Negative login did not trigger an error ❌ (no error message found)");
    }

    @Test
    public void loginPositiveTest() {
        String testEmail = "Sergey1@gmail.com";
        String password = "Password123!";

        click(By.cssSelector("a.ico-login"));

        type(By.cssSelector("Email"), testEmail);
        type(By.cssSelector("Password"), password);

        click(By.cssSelector("input.button-1.login-button"));

        boolean loggedIn = isElementPresent(By.cssSelector(".header-links a[href='/logout']"));
        System.out.println(loggedIn
                ? "Positive login successful ✅ (Logout link is visible)"
                : "Positive login failed ❌ (Logout link is not visible)");
    }
    @Test
    public void register_logout_login_positive_in_one_test() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "Sergey" + i + "@gmail.com";
        String password = "Password123!";

        // 1) Register
        click(By.cssSelector("a.ico-register"));
        type(By.id("FirstName"), "Sergey");
        type(By.id("LastName"),  "Tester" + i);
        type(By.id("Email"),     email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
        click(By.id("register-button"));

        boolean registered = isElementPresent(By.cssSelector(".header-links a[href='/logout']"));
        System.out.println(registered
                ? "Registration successful ✅"
                : "Registration failed ❌");
        if (!registered) return; // stop if registration didn’t succeed

        // 2) Logout
        click(By.cssSelector(".header-links a[href='/logout']"));

        // 3) Login with the SAME creds
        click(By.cssSelector("a.ico-login"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));

        boolean loggedIn = isElementPresent(By.cssSelector(".header-links a[href='/logout']"));
        System.out.println(loggedIn
                ? "Positive login successful ✅ (Logout link is visible)"
                : "Positive login failed ❌ (Logout link is not visible)");
    }
}

