package day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
//        checkBoxes.get(0).click();
         BrowserUtils.wait(2);
        for (int i = 0; i < checkBoxes.size(); i++) {
        if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {
            checkBoxes.get(i).click();
            System.out.println(i+1 + " checkbox is clicked");
        }else{
            System.out.println(i+1 + " checkedbox wasn't clicked ");
        }
        }
        BrowserUtils.wait(2);
        driver.quit();
    }


}
