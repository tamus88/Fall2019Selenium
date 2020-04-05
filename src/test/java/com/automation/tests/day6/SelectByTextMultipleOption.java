package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOption {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languages = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languages.isMultiple();
        System.out.println(isMultiple);
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");

        List<WebElement> selectedLanguages= languages.getAllSelectedOptions();
        for (WebElement each :selectedLanguages) {
            System.out.println(each.getText());
        }
        BrowserUtils.wait(3);
        languages.deselectByVisibleText("Java");

        BrowserUtils.wait(3);
        driver.quit();
    }

}
