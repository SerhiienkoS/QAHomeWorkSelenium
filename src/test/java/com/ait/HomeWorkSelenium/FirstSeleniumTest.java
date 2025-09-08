package com.ait.HomeWorkSelenium;

import org.openqa.selenium.By;
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

    @Test
    public void findTenElementsOnDemoWebShop() {
        // Переходим на страницу из задания
        driver.get("https://demowebshop.tricentis.com");

        // 1) Лого в шапке (картинка)
        driver.findElement(By.cssSelector(".header-logo img"));

        // 2) Ссылка Register
        driver.findElement(By.linkText("Register"));

        // 3) Ссылка Log in
        driver.findElement(By.linkText("Log in"));

        // 4) Корзина (узел <a> внутри #topcartlink)
        driver.findElement(By.cssSelector("#topcartlink a"));

        // 5) Поле поиска (id)
        driver.findElement(By.id("small-searchterms"));

        // 6) Кнопка поиска (класс)
        driver.findElement(By.cssSelector("input.search-box-button"));

        // 7) Пункт верхнего меню "Books"
        driver.findElement(By.cssSelector(".top-menu a[href='/books']"));

        // 8) Заголовок блока Featured products
        driver.findElement(By.xpath("//div[@class='title']/strong[text()='Featured products']"));

        // 9) Поле ввода email для рассылки (newsletter)
        driver.findElement(By.id("newsletter-email"));

        // 10) Кнопка голосования в опросе (poll)
        driver.findElement(By.id("vote-poll-1"));
    }
    //--------------------------------------------------------------CSS----------------------------------------------------------

    // 1) Только CSS-селекторы
    @Test
    public void findTenElementsWithCss() {
        driver.get("https://demowebshop.tricentis.com");

        // 1. Лого в шапке
        driver.findElement(By.cssSelector(".header-logo img"));

        // 2. Ссылка Register
        driver.findElement(By.cssSelector("a.ico-register"));

        // 3. Ссылка Log in
        driver.findElement(By.cssSelector("a.ico-login"));

        // 4. Корзина в шапке
        driver.findElement(By.cssSelector("#topcartlink a.ico-cart"));

        // 5. Поле поиска (input)
        driver.findElement(By.cssSelector("#small-searchterms"));

        // 6. Кнопка поиска
        driver.findElement(By.cssSelector("input.search-box-button"));

        // 7. Пункт верхнего меню "Books"
        driver.findElement(By.cssSelector(".top-menu a[href='/books']"));

        // 8. Заголовок блока Featured products
        driver.findElement(By.cssSelector(".home-page-product-grid .title > strong"));

        // 9. Поле email в Newsletter
        driver.findElement(By.cssSelector("#newsletter-email"));

        // 10. Кнопка голосования в опросе
        driver.findElement(By.cssSelector("#vote-poll-1"));
    }

    //-----------------------------------------------xPath-----------------------------------
    // 2) Только XPath
    @Test
    public void findTenElementsWithXpath() {
        driver.get("https://demowebshop.tricentis.com");

        // 1. Лого в шапке
        driver.findElement(By.xpath("//div[@class='header-logo']//img"));

        // 2. Ссылка Register
        driver.findElement(By.xpath("//a[@class='ico-register' or @href='/register']"));

        // 3. Ссылка Log in
        driver.findElement(By.xpath("//a[@class='ico-login' or @href='/login']"));

        // 4. Корзина в шапке
        driver.findElement(By.xpath("//*[@id='topcartlink']//a[contains(@class,'ico-cart')]"));

        // 5. Поле поиска (input)
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));

        // 6. Кнопка поиска
        driver.findElement(By.xpath("//input[contains(@class,'search-box-button')]"));

        // 7. Пункт верхнего меню "Books"
        driver.findElement(By.xpath("//ul[contains(@class,'top-menu')]//a[@href='/books']"));

        // 8. Заголовок блока Featured products
        driver.findElement(By.xpath("//div[contains(@class,'home-page-product-grid')]//div[@class='title']/strong"));

        // 9. Поле email в Newsletter
        driver.findElement(By.xpath("//*[@id='newsletter-email']"));

        // 10. Кнопка голосования в опросе
        driver.findElement(By.xpath("//*[@id='vote-poll-1']"));
    }

    //after - tearDown
    @AfterMethod(enabled = true)
    public void tearDown() {
//        driver.quit(); // all tabs and browser (он закрывает все вкладки и браузер)
        driver.close(); // only ona tab (if only one -> close browser) текущая
    }
}
