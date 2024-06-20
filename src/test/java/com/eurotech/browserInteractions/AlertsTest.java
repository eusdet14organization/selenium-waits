package com.eurotech.browserInteractions;

import com.eurotech.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    void jsAlertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        Assert.assertEquals("I am a JS Alert", alert.getText());
        alert.accept();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        alert.sendKeys("SDET is here");
        Thread.sleep(1000);
        alert.accept();

        Thread.sleep(2000);
    }
}
