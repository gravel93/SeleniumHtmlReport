package com.commondeer.retail;

import org.apache.commons.collections4.list.TreeList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class AllProductPage extends HomePage{

    @FindBy (xpath = "//h1[contains(text(),'American Made')]")
    private WebElement h1NewlyAmericanMade;

    @FindBy(css = "select#SortBy")
    private WebElement selectClick;

    @FindBy(xpath = "//option[@value='price-ascending']")
    private WebElement selectSortAsc;

    @FindBy(css = "div.image-table")
    private List<WebElement> imgtable;

    @FindBy(xpath = "//a[contains(text(),'Burlington Camel')]")
    private WebElement BurlingtonItem;

    @FindBy(css = "button#AddToCart")
    private WebElement addToCard;

    @FindBy(xpath = "//a[contains(text(),\"Burlington Camel's Hump Landscape Badge Sticker\")]")
    private WebElement titleTextofItemBur;

    @FindBy(xpath = "//span[@class='icon icon-list']")
    private WebElement changeViewOfList;

    @FindBy(xpath = "//a[@href='/collections/all-products-1?page=2'][contains(text(),'2')]")
    private WebElement changepage;

    @FindBy(css = "span.money")
    private  List<WebElement> itemPrice;


//    public void SelectProductWith20(){
//        String items = " ";
//
//
////        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i <itemPrice.size() ; i++) {
//              items +=  itemPrice.get(i).getText();
//        }
//        String[] replaceAndToArray = items.replace("$"," ").split(" ");
//
//    }



    public void sortBy(){
        dropDownSearchFunc();
        selectClick.click();
        selectSortAsc.click();
        int numOfPic =  imgtable.size();
        System.out.println(numOfPic);


    }

    public void changeView(){
        dropDownSearchFunc();
        click(changeViewOfList,"changeViewOfList");

    }

    public void changePage(){
        dropDownSearchFunc();
        click(changepage,"ChangePAge");

    }

    public String getTitleText(){
        String actualText = getText(titleTextofItemBur,"titleTextofItemBur");
        return actualText;
    }
    public String geTh1NewlyAmericanMade(){
        String actualText = getText(h1NewlyAmericanMade,"h1NewlyAmericanMade");
        return actualText;
    }


    public void selectItemToshoppingList(){
        dropDownSearchFunc();
        selectSortAsc.click();
        BurlingtonItem.click();
        ExplicitWait(driver,addToCard,5);
        addToCard.click();

    }


}
