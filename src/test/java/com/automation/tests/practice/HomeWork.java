package com.automation.tests.practice;

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

public class HomeWork {
    private String URL = "http://practice-cybertekschool.herokuapp.com";
    private WebDriver driver;
@Test
public void aploaded(){
    driver.findElement(By.cssSelector("a[href='/upload']")).click();
    WebElement upload = driver.findElement(By.cssSelector("input[id='file-upload']"));
    String filePath = "/Users/tamarasuleymanova/Desktop/Notes/image.png";
    //String filePath2 = "/Users/tamarasuleymanova/Desktop/Shortcuts/2.png";
    upload.sendKeys(filePath);
    driver.findElement(By.cssSelector("input[id='file-submit']")).click();
    BrowserUtils.wait(3);
    String expected = "File Uploaded!";
    String actual = driver.findElement(By.tagName("h3")).getText();
    Assert.assertEquals(expected,actual);

}
@Test(description="Auto Complete")
public void autoCompleted(){
    driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
    driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America", Keys.ENTER);
    BrowserUtils.wait(2);
    String expected = "You selected: United States of America";
    String actual = driver.findElement(By.xpath("//p[text()='You selected: United States of America']")).getText();
    Assert.assertEquals(expected,actual);
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
