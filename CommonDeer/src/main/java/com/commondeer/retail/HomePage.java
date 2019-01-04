package com.commondeer.retail;

import com.aplicationpagebase.ApplicationPageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static javafx.beans.binding.Bindings.select;

public class HomePage extends ApplicationPageBase {



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

    @FindBy(xpath = "//div[@class='js-flickity flickity-enabled is-draggable']//button[2]")
    private  WebElement changeSlidePic;

    @FindBy(xpath = "//a[text()='Newly Online'][1]")
    private  WebElement newlyOnline;

    @FindBy(xpath = "//*[@class='nav-bar']/ul/li/a[text()='Search']")
    private WebElement searchPageElement;

    @FindBy(xpath = "//div[@class='collection-container']//input[@placeholder='Search our store']")
    private  WebElement searchBox;

    @FindBy(xpath = "//a[contains(text(),'Wilson D-Loop Keyring')]")
    private WebElement keysItem;

    @FindBy(xpath = "//*[@class='nav-bar']//ul//li/a[text()='Accesssories & Hats']")
    private WebElement AcceandHats;

    @FindBy(xpath = "//h1[text()='American Made Accessories']")
    private WebElement titleOfAccesandHatsPage;

    @FindBy(xpath = "//a[@title='layout.pagination.next_html']")
    private WebElement ChangePage;

    @FindBy(xpath = "//ul[@class='pagination']//li")
    private List<WebElement> ulofChangePage;

    @FindBy(xpath = "//*[@class='image-table']")
    private List<WebElement> pictures;



    public void changePage()  {
        int numberOfPictures = 0;
        int numbOfPages = ulofChangePage.size();
        while (numbOfPages!=1){
            numbOfPages--;
            ChangePage.click();
            numberOfPictures += pictures.size();
        }
        System.out.println(numberOfPictures);
    }


    public void goToAccessoriesNHats(){
        hoverOver(dropDownSearch,"dropDownSearch");
        click(AcceandHats,"AcceandHats");
    }

    public String getTitlleOftitleOfAccesandHatsPage(){
      String actualText =  getText(titleOfAccesandHatsPage,"titleOfAccesandHatsPage");
      return actualText;
    }


    public void searchPage() {
        searchPageElement.click();
        searchBox.sendKeys("Wilson D-Loop Keyring",Keys.ENTER);
    }


    public void dropDownSearchFunc(){

        hoverOver(dropDownSearch,"dropDownSearch");
        click(dropDownSearch,"dropDownSearch");

    }

    public boolean logoVerification(){
        boolean logoDis =  isDisplayed(logoVerification,"logoVerification");
         return logoDis;
    }


    public void search(){

        searchBtn.click();
        searchInput.sendKeys("Shirts");
        searchInput.sendKeys(Keys.ENTER);
        clickOnShirt.click();

    }

    public String getTitleText(){
     String actualText = getText(keysItem,"keysItem");
     return  actualText;
    }



    public void slidePictutes(){
        Actions actions = new Actions(driver);
        actions.doubleClick(changeSlidePic).build().perform();
    }

    public void clickOnNewlyOnline(){
        click(newlyOnline,"newlyOnline");
    }




    }


