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




    @Test
    public void sortByTest(){
        String NOAMG = "NEWLY ONLINE AMERICAN MADE GOODS";
        objAllProductPage.sortBy();
        assertExpection(objAllProductPage.geTh1NewlyAmericanMade(),"h1NewlyAmericanMade",NOAMG);
    }



    @Test
    public void selectItemToshoppingListTest(){

        objAllProductPage.selectItemToshoppingList();
        String expectText = "Burlington Camel's Hump Landscape Badge Sticker";
        assertExpection(objAllProductPage.getTitleText(),"titleTextofItemBur",expectText);

    }


    @Test
    public void  changeViewTest(){
        objAllProductPage.changeView();
    }

//    @Test(priority = 5)
//    public void changePageTest(){
//        objAllProductPage.changePage();
//    }





}

