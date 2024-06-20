package com.eurotech.browserInteractions;

import com.eurotech.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class CookieTest extends BaseTest {

    @Test
    void cookieTest(){
        driver.get("http://www.example.com");
        driver.manage().addCookie(new Cookie("name", "Cookie value"));
        Cookie cookie = driver.manage().getCookieNamed("name");
        System.out.println(cookie);
    }
}
