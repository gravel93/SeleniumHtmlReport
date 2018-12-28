package com.commondeer.retailtest;

import com.commondeer.retail.CustomerInformationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerInformationPageTest extends CustomerInformationPage {

    CustomerInformationPage objofCustomeInfoPage = new CustomerInformationPage();


    @BeforeMethod

    public void initializationOfElements() {

        objofCustomeInfoPage = PageFactory.initElements(driver, CustomerInformationPage.class);
    }

    @Test
    public void customerFillInfoPageTest() throws InterruptedException {
        objofCustomeInfoPage.customerFillInfoPage();
    }

}
