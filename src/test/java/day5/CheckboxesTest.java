package day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(3);
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

            if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
                System.out.println("Test passed");
            }else{
                System.out.println("Test failed");
            }
        BrowserUtils.wait(3);
        checkBoxes.get(0).click();
        driver.quit();
    }


}
