package com.commondeer.retail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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


    public void sortBy(){
        dropDownSearchFunc();
        selectClick.click();
        selectSortAsc.click();
        int numOfPic =  imgtable.size();
        System.out.println(numOfPic);
        String NOAMG = "NEWLY ONLINE AMERICAN MADE GOODS";
        String getTitle = h1NewlyAmericanMade.getText();
        Assert.assertEquals(NOAMG,getTitle);
        System.out.println("h1 Title matched");

    }

    public String getTitleText(){
        String actualText = getText(titleTextofItemBur,"titleTextofItemBur");
        return actualText;
    }

    public void selectItemToshoppingList(){
        dropDownSearchFunc();
        selectSortAsc.click();
        BurlingtonItem.click();
        addToCard.click();

    }


}
