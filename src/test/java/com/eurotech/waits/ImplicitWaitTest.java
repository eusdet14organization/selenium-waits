package com.eurotech.waits;

import com.eurotech.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest extends BaseTest {

    @Test
    void removeCheckboxTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement message = driver.findElement(By.id("message"));

        Assert.assertEquals(message.getText(), "It's gone!");
    }
}
