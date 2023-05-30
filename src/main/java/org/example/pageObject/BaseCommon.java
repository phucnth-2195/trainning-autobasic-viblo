package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Method;

public class BaseCommon {

    public WebDriver driver;

    // open browser with url
    public  void openDriver(String url){
        driver.get(url);
    }

    public void closeDriver(){
        driver.close();
    }

    // quit driver
    public void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // wait to element displays
    public void waitUntilDisplay(WebElement selectElement){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectElement));
    }
}
