package com.commondeer.retail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCard extends AllProductPage {

    @FindBy(css = "a#CartButton")
    private WebElement cardBtn;

    @FindBy(xpath = "//button[@class='adjust adjust-plus']")
    private WebElement adjuctItem;

    @FindBy(xpath = "//span[@class='price money']")
    private WebElement totalPrice;

    @FindBy(css = "textarea#CartSpecialInstructions")
    private WebElement leaveText;

    @FindBy (css = "input[value='Update Cart']")
    private WebElement updateCard;

    @FindBy(css = "input[value='Check Out']")
    private  WebElement checkOut;





    public void checkOutFunc() throws InterruptedException {
        selectItemToshoppingList();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cardBtn));
        element.click();
//        ExplicitWait(driver,cardBtn,5);
        adjuctItem.click();
        updateCard.click();
        String total = totalPrice.getText();
        leaveText.sendKeys("Amazing Website");
        checkOut.click();
        System.out.println(total);




    }

}
