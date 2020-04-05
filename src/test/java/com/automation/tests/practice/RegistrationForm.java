package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By numberBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By DOBBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By cPlusPlusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By signUpBy = By.id("wooden_spoon");
    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Toma");
        driver.findElement(lastNameBy).sendKeys("Sulik");
        driver.findElement(userNameBy).sendKeys("tamus88");
        driver.findElement(emailBy).sendKeys("sdrt@mail.com");
        driver.findElement(passwordBy).sendKeys("secretpassword");
        driver.findElement(numberBy).sendKeys("786-954-3678");
        driver.findElement(femaleBy).click();
        driver.findElement(DOBBy).sendKeys("09/24/1990");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("Product Owner");
        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();
        BrowserUtils.wait(5);
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void verifyNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warning = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warning.isDisplayed());
    }
    @Test
    public void verifyAlphabeticTestOnly(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warning = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warning.isDisplayed());
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
