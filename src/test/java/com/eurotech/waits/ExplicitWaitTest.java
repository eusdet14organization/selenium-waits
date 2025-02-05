package com.eurotech.waits;

import com.eurotech.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest extends BaseTest {

    @Test
    void helloWorldTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("#start > button")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish > h4"));

        wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    void helloWorldTestLambdaWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start > button")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish > h4"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(x -> text.isDisplayed());

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    void waitForEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebElement input = driver.findElement(By.cssSelector("#input-example > input[type=text]"));

        wait.until(ExpectedConditions.elementToBeClickable(input));

        input.sendKeys("Hello world!");

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(), "It's enabled!");
    }
}
