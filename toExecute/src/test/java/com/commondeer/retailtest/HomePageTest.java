package com.commondeer.retailtest;

import com.commondeer.retail.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends HomePage {

    HomePage objHomePage = null;

    @BeforeMethod
    public void initializationOfElements() {

        objHomePage = PageFactory.initElements(driver, HomePage.class);

    }


    @Test(priority = 0)
    public void changePageTest() {
        objHomePage.goToAccessoriesNHats();
        objHomePage.changePage();
    }


        @Test(priority =1)
    public void goToAccessoriesNHatsTest(){
        objHomePage.goToAccessoriesNHats();
        assertExpection(objHomePage.getTitlleOftitleOfAccesandHatsPage(),"titleOfAccesandHatsPage","AMERICAN MADE ACCESSORIES");
    }


    @Test(priority =2)
    public void searchTest (){
        objHomePage.search();

    }

    @Test(priority =3)
    public void dropDownSearchFuncTest(){

        objHomePage.dropDownSearchFunc();
        Assert.assertEquals(objHomePage.logoVerification(),true);
    }

    @Test(priority =4)
    public void slidePictutesTest(){
        objHomePage.slidePictutes();
    }

    @Test(priority =5)
    public void clickOnNewlyOnlineTest(){
        objHomePage.clickOnNewlyOnline();
    }

    @Test(priority =6)
    public void searchPageTest() throws IOException {
        objHomePage.searchPage();
        assertExpection(objHomePage.getTitleText(),"searchBox","Wilson D-Loop Keyring");
    }



}
