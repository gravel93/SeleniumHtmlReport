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
//
//    @Test(priority = 1)
//    public void SelectProductWith20Test(){
//        objAllProductPage.SelectProductWith20();
//    }


    @Test(priority = 2)

    public void sortByTest(){
        String NOAMG = "NEWLY ONLINE AMERICAN MADE GOODS";
        objAllProductPage.sortBy();
        assertExpection(objAllProductPage.geTh1NewlyAmericanMade(),"h1NewlyAmericanMade",NOAMG);
    }


    @Test(priority = 3)

    public void selectItemToshoppingListTest(){

        objAllProductPage.selectItemToshoppingList();
        String expectText = "Burlington Camel's Hump Landscape Badge Sticker";
        assertExpection(objAllProductPage.getTitleText(),"titleTextofItemBur",expectText);

    }


    @Test(priority = 4)
    public void  changeViewTest(){
        objAllProductPage.changeView();
    }

    @Test(priority = 5)
    public void changePageTest(){
        objAllProductPage.changePage();
    }





}

