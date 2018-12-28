package com.commondeer.retailtest;

import com.commondeer.retail.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Login {

    Login objLogin = null;


    @BeforeMethod
    public void initializationOfElements() {

        objLogin = PageFactory.initElements(driver, com.commondeer.retail.Login.class);
    }

        @Test(priority = 7)
    public void loginTest() {
            objLogin.loginfunc();
        }

    }


