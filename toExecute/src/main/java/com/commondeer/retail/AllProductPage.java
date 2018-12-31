package com.commondeer.retail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BurlingtonItem));
        element.click();
        addToCard.click();

    }


}
