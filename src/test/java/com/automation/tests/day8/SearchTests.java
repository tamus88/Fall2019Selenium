package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement each :searchItems) {
            String var = each.getText();
            if (!var.isEmpty()) {
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));

            }
        }
    }
   @Test
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java",Keys.ENTER);
       BrowserUtils.wait(3);
        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));
        searchItems.get(0).click();
       BrowserUtils.wait(5);

       WebElement productTitle = driver.findElement(By.id("ebooksProductTitle"));
        String titleString = productTitle.getText();
       System.out.println(titleString);
        Assert.assertTrue(titleString.contains("Java"));
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
