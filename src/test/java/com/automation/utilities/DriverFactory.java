package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver createADriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            return new SafariDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
       return new FirefoxDriver();
        }
    }
}
