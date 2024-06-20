package com.eurotech.waits;

import com.eurotech.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest extends BaseTest {

    @Test
    void fluentWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start > button")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish > h4"));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Элемент не отображается:" + text.getTagName());
        wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    void enterTextWait() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebElement input = driver.findElement(By.cssSelector("#input-example > input[type=text]"));

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Элемент не отображается:" + input.getTagName());
        wait.until(d -> {
            input.sendKeys("Hello world!");
            return true;
        });

        Thread.sleep(3000);
        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(), "It's enabled!");
    }
}
