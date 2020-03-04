package com.automation.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);
        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles);
        for (String windowID :windowHandles) {
            if(!windowID.equals(windowHandle)){
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("After switch : " + driver.getCurrentUrl());
        driver.close();
    }

}
