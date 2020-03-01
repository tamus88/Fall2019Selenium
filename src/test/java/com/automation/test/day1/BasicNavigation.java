package com.automation.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("Title is :" + title);
        if(expectedTitle.equals(title)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }
        driver.navigate().back();
       driver.navigate().refresh();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(),"Google");
        System.out.println("URL : " + driver.getCurrentUrl());
        driver.navigate().forward();

        driver.close();
    }
        public static void verifyEquals(String arg1,String arg2){
        if(arg1.equals(arg2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test failed");
        }
        }
}
