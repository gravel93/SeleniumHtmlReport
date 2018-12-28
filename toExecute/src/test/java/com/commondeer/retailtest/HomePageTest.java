package com.commondeer.retailtest;

import com.commondeer.retail.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends HomePage {

    HomePage objHomePage = null;

    @BeforeMethod
    public void initializationOfElements() {

        objHomePage = PageFactory.initElements(driver, HomePage.class);

    }
    @Test(priority = 1)
    public void searchTest (){

        objHomePage.search();
        objHomePage.logo();

    }

    @Test(priority = 2)
    public void dropDownSearchFuncTest(){
        objHomePage.dropDownSearchFunc();
    }




}
