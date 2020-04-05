package com.automation.warmUp;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Practice {
    private String URL = "https://qa2.vytrack.com/user/login";
    private By customersBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Customers')]");
    private By accountTitle = By.className("oro-subtitle");
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @Test
    public void goToAccount() {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(customersBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Accounts")).click();
        BrowserUtils.wait(3);
        WebElement title = driver.findElement(accountTitle);
        BrowserUtils.wait(3);
        String expected1 = "All Accounts";
        String actual1 = title.getText();
        Assert.assertEquals(expected1, actual1);
        BrowserUtils.wait(3);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
