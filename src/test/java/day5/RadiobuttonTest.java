package day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadiobuttonTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
       if(blackButton.isDisplayed() && blackButton.isEnabled()) {
           blackButton.click();
       }
        if(blackButton.isSelected()){
        System.out.println("Test passed");
    }else{
        System.out.println("Test failed");
    }
        driver.quit();
    }


}
