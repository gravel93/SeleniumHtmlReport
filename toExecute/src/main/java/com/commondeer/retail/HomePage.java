package com.commondeer.retail;

import main.java.ForEveryClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.xpath.XPath;

public class HomePage extends ForEveryClass {



    @FindBy(xpath = "//img[@alt='Common Deer']")
    private WebElement logoVerification;

    @FindBy (how = How.XPATH ,using = "//ul[@class='text-links'][1]")
    private WebElement searchBtn;

    @FindBy (how = How.XPATH,using = "//input[@type='search'][1]")
    private  WebElement searchInput;

    @FindBy(xpath = "//a[contains(text(),'Mount Philo T-Shirt')]")

    private WebElement clickOnShirt;


    @FindBy (xpath ="//a[contains(text(),'Shop the Goods')][1]" )

    private WebElement dropDownSearch;

    @FindBy (xpath = "//a[contains(text(),'All Products')][1]")

    private WebElement hoverOverOnShopTheGoods;

    @FindBy(css = "div.play-icon")

    private WebElement videoClick;




    public void logo(){
        boolean logoDisplay = logoVerification.isDisplayed();
        Assert.assertEquals(logoDisplay,true);
        System.out.println("Logo displayed" + " " +logoDisplay);

    }




    public void dropDownSearchFunc(){

        Actions action = new Actions(driver);
        action.moveToElement(dropDownSearch).build().perform();
        hoverOverOnShopTheGoods.click();
    }



    public void search(){


        searchBtn.click();
        searchInput.sendKeys("Shirts");
        searchInput.sendKeys(Keys.ENTER);
        clickOnShirt.click();

    }




    }


