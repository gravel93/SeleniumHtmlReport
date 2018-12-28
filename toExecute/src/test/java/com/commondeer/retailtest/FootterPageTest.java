package com.commondeer.retailtest;

import com.commondeer.retail.FootterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FootterPageTest extends FootterPage {

    FootterPage objOfFottPage = null;

                @BeforeMethod
    public void initializationOfElements() {

        objOfFottPage = PageFactory.initElements(driver, FootterPage.class);
    }

    @Test

    public  void  countLiTest(){
        objOfFottPage.countLi();
    }

}
