package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBase {

    public static WebDriver buildSetupDriver() {
        String pathChrome = "D:\\PHUC\\Auto\\Practice1\\src\\main\\lib\\chrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        return (WebDriver) new ChromeDriver();
    }
}
