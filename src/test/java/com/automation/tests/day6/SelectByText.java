package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        Select selectSimple = new Select(simpleDropDown);
        selectSimple.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimple.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));
        year.selectByVisibleText("1988");
        month.selectByVisibleText("September");
        day.selectByVisibleText("24");
        BrowserUtils.wait(3);
        List<WebElement> months=month.getOptions();
        for (WebElement each :months) {
            String monthName = each.getText();
            month.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
            List<WebElement> days=day.getOptions();
            for (WebElement eachday :days) {
                String daysName = eachday.getText();
                day.selectByVisibleText(daysName);
                BrowserUtils.wait(1);
            }
        BrowserUtils.wait(3);
        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByVisibleText("District Of Columbia");
        String selected = state.getFirstSelectedOption().getText();
        if(selected.equalsIgnoreCase("District Of Columbia")){
            System.out.println("Test passed");
        }else{
            System.out.println("test failed");
        }

        BrowserUtils.wait(3);
        driver.quit();
    }


}
