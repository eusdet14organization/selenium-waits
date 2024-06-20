package com.eurotech.browserInteractions;

import com.eurotech.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    void navigationTest() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(11) > a")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test
    void titleAndUrlTest() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
