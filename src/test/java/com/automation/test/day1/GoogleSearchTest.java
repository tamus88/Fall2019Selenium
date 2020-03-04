package com.automation.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Java", Keys.ENTER);
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        driver.quit();

    }

    public String everyNth(String str, int n) {
        String result = "";
        for(int x = 0; x<str.length(); x=+n){
             result = ""+str.charAt(x);
        }
        return result;
    }

}