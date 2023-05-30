package org.example.pageObject;

import org.example.config.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VibloPage extends BaseCommon {
    public WebDriver openPage() {
        String accessUrl = "https://accounts.viblo.asia/login";
        BaseCommon baseCommon = new BaseCommon();
        baseCommon.driver = DriverBase.buildSetupDriver();
        baseCommon.openDriver("https://accounts.viblo.asia/login");
        PageFactory.initElements(driver, this);
        return baseCommon.driver;
    }

    public VibloPage() {
        this.driver = DriverBase.buildSetupDriver();
        this.driver.get("https://accounts.viblo.asia/login");
//        this.driver.manage().window().maximize(); // open fullscreen = F11 //when executing with multiple TCs, system is quite lag
        PageFactory.initElements(driver, this);
    }

    //Find elements on Login page
    @FindBy(how = How.CSS, using = "input[type='text']")
    public WebElement emailTxb;

    @FindBy(how = How.CSS, using = "input[type='password']")
    public WebElement passWordTxb;

    @FindBys
            ({
                    @FindBy(xpath = "//input[@type='text']//ancestor::div[@class='el-form-item__content']//child::div[@class='el-form-item__error']"),
            })
    public List<WebElement> emailError;

    @FindBys
            ({
                    @FindBy(xpath = "//input[@type='password']//ancestor::div[@class='el-form-item__content']//child::div[@class='el-form-item__error']"),
            })
    public List<WebElement> passwordError;

    @FindBy(xpath = "//button[contains(@class,'el-button--primary')]")
    public WebElement loginBtn;

    //Find elements on Account page
    @FindBy(xpath = "//h1[@class='greeting-title']")
    public WebElement welcomeLb;
}
