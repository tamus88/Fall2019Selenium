package day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class radioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        for (WebElement each :radioButtons) {
          String id = each.getAttribute("id");
           boolean isSelected = each.isSelected();
            System.out.println(id + " is selected?" +isSelected);
           if(each.isEnabled()){
               each.click();
               System.out.println("Clicked on : " + id);
               BrowserUtils.wait(1);
           }else{
               System.out.println("Button is disabled, not clicked :" + id);
           }

        }
        driver.quit();


    }


}
