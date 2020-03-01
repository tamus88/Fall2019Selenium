package com.automation.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        Thread.sleep(3000);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("Title is :" + title);
        if(expectedTitle.equals(title)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.close();
    }

}
