package com.commondeer.retailtest;

import com.commondeer.retail.AllProductPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductPageTest extends AllProductPage {
    AllProductPage objAllProductPage = new AllProductPage();

    @BeforeMethod
    public void initializationOfElements() {

        objAllProductPage = PageFactory.initElements(driver, AllProductPage.class);
    }


    @Test(priority = 4)

    public void sortByTest(){
        objAllProductPage.sortBy();
    }


    @Test(priority = 5)

    public void selectItemToshoppingListTest(){

        objAllProductPage.selectItemToshoppingList();
        String expectText = "Burlington Camel's Hump Landscape  Sticker";
        String actualText = objAllProductPage.getTitleText();
        Assert.assertEquals(expectText,actualText);
        System.out.println("Title matched");
    }






}

