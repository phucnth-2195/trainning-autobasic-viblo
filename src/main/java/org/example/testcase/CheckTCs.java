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

//    Displays Login page successfully
    @Test
    public void testCase1(){
        VibloPage vibloPage = new VibloPage();
        Assert.assertEquals(vibloPage.openPage().getTitle(),loginTitlePage);
        vibloPage.driver.close();
    }

    //Error returns with empty on all required fields
    @Test
    public void testCase2() {
        VibloPage vibloPage = new VibloPage();
        vibloPage.loginBtn.click();
        vibloPage.waitUntilDisplay(vibloPage.emailError.get(0));
        Assert.assertEquals(vibloPage.emailError.get(0).getText(),errorRequiedEmail);
        Assert.assertEquals(vibloPage.passwordError.get(0).getText(),errorRequiredPassword);
        vibloPage.driver.close();
    }

    //Error returns with empty on email
    @Test
    public void testCase3() throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        vibloPage.passWordTxb.sendKeys(passWord);
        vibloPage.loginBtn.click();
        Thread.sleep(300);
        Assert.assertEquals(vibloPage.emailError.get(0).getText(), errorRequiedEmail);
        Assert.assertEquals(vibloPage.passwordError.size(),0);
        vibloPage.driver.close();
    }

    //Error returns with empty on password
    @Test
    public void testCase4() throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        vibloPage.emailTxb.sendKeys(email);
        vibloPage.loginBtn.click();
        Thread.sleep(300);
        Assert.assertEquals(vibloPage.passwordError.get(0).getText(), errorRequiredPassword);
        Assert.assertEquals(vibloPage.emailError.size(),0);
        vibloPage.driver.close();
    }

    //Login successfully with valid data
    @Test
    public void testCase5() {
        VibloPage vibloPage = new VibloPage();
        vibloPage.emailTxb.sendKeys(email);
        vibloPage.passWordTxb.sendKeys(passWord);
        vibloPage.loginBtn.click();
        vibloPage.waitUntilDisplay(vibloPage.welcomeLb);
        Assert.assertEquals(vibloPage.driver.getTitle(),accountTitlePage);
        vibloPage.driver.close();
    }


    public static void main(String[] args) throws InterruptedException {
        VibloPage vibloPage = new VibloPage();
        String email = "annaa";
        String passWord = "Aa@12345678";
        vibloPage.emailTxb.sendKeys(email);
        vibloPage.passWordTxb.sendKeys(passWord);
        vibloPage.loginBtn.click();
        Thread.sleep(5000);
        System.out.println(vibloPage.driver.getTitle());
        vibloPage.driver.close();
    }

}
