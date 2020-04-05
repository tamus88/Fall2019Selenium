package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork2 {
    private String URL = "http://practice-cybertekschool.herokuapp.com";
    private WebDriver driver;

    @Test
    public void status200(){
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='200']")).click();
        BrowserUtils.wait(3);
        String expected = "This page returned a 200 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void status301(){
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='301']")).click();
        BrowserUtils.wait(3);
        String expected = "This page returned a 301 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected,actual);
    }
   @Test
   public void status404(){
       driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
       driver.findElement(By.xpath("//a[text()='404']")).click();
       BrowserUtils.wait(3);
       String expected = "This page returned a 404 status code.\n" +
               "\n" +
               "For a definition and common list of HTTP status codes, go here";
       String actual = driver.findElement(By.tagName("p")).getText();
       Assert.assertEquals(expected,actual);
   }
    @Test
    public void status500() {
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='500']")).click();
        BrowserUtils.wait(3);
        String expected = "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected, actual);

    }
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
