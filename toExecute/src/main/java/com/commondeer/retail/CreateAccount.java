package com.commondeer.retail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAccount extends Login {

    @FindBy (xpath = "//h1[text()= 'Create Account']")
    private WebElement getTitle;
    @FindBy(xpath = "//a[@id='customer_register_link'][1]")
    private WebElement clickCreateAccount;
    @FindBy(css = "input#FirstName")
    private WebElement firstName;
    @FindBy(css = "input#LastName")
    private WebElement lastName;
    @FindBy(css = "input#Email")
    private  WebElement email;
    @FindBy(css = "input#CreatePassword")
    private WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    private  WebElement sumbitbtn;



    public void createNewAccount(){
        Login.click();
        clickCreateAccount.click();
        firstName.sendKeys("Mayajan");
        lastName.sendKeys("JanMaya");
        email.sendKeys(loginEmail);
        password.sendKeys(loginPassword);
        String title =  getTitle.getText();
        Assert.assertEquals("CREATE ACCOUNT",title);
        System.out.println("Title matched");
        sumbitbtn.click();


    }

}
