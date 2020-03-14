package com.automation.test.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
       // driver.findElement(By.linkText("Amazon")).click();

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement each :allLinks) {
            System.out.println(each.getText()+ " : " + each.getAttribute("href"));
        }


        BrowserUtils.wait(3);
        driver.quit();

    }

}
