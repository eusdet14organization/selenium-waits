package com.eurotech.browserInteractions;

import com.eurotech.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    void iFrameTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("Eurotech Was Here");

        driver.switchTo().parentFrame();

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.sendKeys("Eurotech Was Here");
    }
}
