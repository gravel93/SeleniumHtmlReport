package com.commondeer.retailtest;

import com.commondeer.retail.ShoppingCard;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCardTest extends ShoppingCard {

    ShoppingCard objOfShoppingCard = new ShoppingCard();

    @BeforeMethod
    public void initializationOfElements() {

        objOfShoppingCard = PageFactory.initElements(driver, ShoppingCard.class);
    }

    @Test(priority = 6)

    public void checkOutFuncTest() throws InterruptedException {

        objOfShoppingCard.checkOutFunc();

    }


}
