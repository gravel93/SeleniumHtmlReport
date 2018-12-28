package com.commondeer.retail;

import main.java.ForEveryClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends ForEveryClass {

    public static String loginEmail = "1madman@bk.ru";
    public static String loginPassword = "qwer1234";

    @FindBy(xpath = "//h1[text()='Login']")
    private WebElement logInTitle;

    @FindBy(xpath = "//a[@id='customer_login_link'][1]")
    public static WebElement Login;

    @FindBy(css = "input#CustomerEmail")
    private WebElement email;

    @FindBy(css = "input#CustomerPassword")
    private WebElement password;

    @FindBy (xpath = "//input[@value='Sign In']")
    private WebElement logInBtn;

    @FindBy(css = "div.recaptcha-checkbox-checkmark")
    private  WebElement cookies;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement loginSumbitBtn;

    public void loginfunc() {

        Login.click();
        String Ltitle = logInTitle.getText();
        Assert.assertEquals("LOGIN",Ltitle);
        System.out.println("Title Matched");
        email.sendKeys(loginEmail);
        password.sendKeys(loginEmail);
        logInBtn.click();
//        cookies.click();
//        loginSumbitBtn.click();


    }


}
