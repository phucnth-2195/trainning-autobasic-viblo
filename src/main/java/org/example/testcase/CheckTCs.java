package org.example.testcase;

import org.example.pageObject.VibloPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTCs {
    String email = "annaa";
    String passWord = "Aa@12345678";
    String errorRequiedEmail = "Tên người dùng/email là bắt buộc";
    String errorRequiredPassword = "Mật khẩu là bắt buộc";
    String loginTitlePage = "Viblo - Login";
    String accountTitlePage = "Viblo Accounts";

    @Test(description = "Displays Login page successfully")
    public void testCase1() {
        VibloPage vibloPage = new VibloPage();
        Assert.assertEquals(vibloPage.driver.getTitle(), loginTitlePage);
        vibloPage.closeDriver();
    }

    @Test(description = "Error returns with empty on all required fields")
    public void testCase2() throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        vibloPage.loginBtn.click();
        Thread.sleep(500);
        Assert.assertEquals(vibloPage.emailError.get(0).getText(), errorRequiedEmail);
        Assert.assertEquals(vibloPage.passwordError.get(0).getText(), errorRequiredPassword);
        vibloPage.closeDriver();
    }

    @Test(description = "Error returns with empty on email")
    public void testCase3() throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        vibloPage.passWordTxb.sendKeys(passWord);
        vibloPage.loginBtn.click();
        Thread.sleep(500);
        Assert.assertEquals(vibloPage.emailError.get(0).getText(), errorRequiedEmail);
        Assert.assertEquals(vibloPage.passwordError.size(), 0);
        vibloPage.closeDriver();
    }

    @Test(description = "Error returns with empty on password")
    public void testCase4() throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        vibloPage.emailTxb.sendKeys(email);
        vibloPage.loginBtn.click();
        Thread.sleep(500);
        Assert.assertEquals(vibloPage.passwordError.get(0).getText(), errorRequiredPassword);
        Assert.assertEquals(vibloPage.emailError.size(), 0);
        vibloPage.closeDriver();
    }

    @Test(description = "Login successfully with valid data")
    public void testCase5() {
        VibloPage vibloPage = new VibloPage();
        vibloPage.emailTxb.sendKeys(email);
        vibloPage.passWordTxb.sendKeys(passWord);
        vibloPage.loginBtn.click();
        vibloPage.waitUntilDisplay(vibloPage.welcomeLb);
        Assert.assertEquals(vibloPage.driver.getTitle(), accountTitlePage);
        vibloPage.closeDriver();
    }
}
