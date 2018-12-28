package com.commondeer.retailtest;

import com.commondeer.retail.CreateAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends CreateAccount {


    CreateAccount objcreateAcc = null;


    @BeforeMethod
    public void initializationOfElements() {

        objcreateAcc = PageFactory.initElements(driver, CreateAccount.class);
    }

    @Test(priority = 3)
    public void createNewAccountTest(){
        objcreateAcc.createNewAccount();
    }

}
