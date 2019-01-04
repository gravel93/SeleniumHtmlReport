package com.commondeer.retailtest;

import com.commondeer.retail.CustomerInformationPage;
import com.util.xlsx.reader.MyDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;




public class CustomerInformationPageTest extends CustomerInformationPage {

    CustomerInformationPage objofCustomeInfoPage = null;


    @BeforeMethod

    public void initializationOfElements() {

        objofCustomeInfoPage = PageFactory.initElements(driver, CustomerInformationPage.class);
    }


    @DataProvider(name="PC")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/testData/PromoCode.xlsx");
        MyDataReader dr = new MyDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());
        String[][] data = dr.getExcelSheetData("Sheet3");
        return data;
    }

            @Test(dataProvider = "PC")
    public void invalidPromoCode(String promodeCode,String expectedErroMessage) throws InterruptedException {
        objofCustomeInfoPage.customerFillInfoPage();
        objofCustomeInfoPage.invalidPromoCode(promodeCode);
        String expectedText = expectedErroMessage;
        String actulText = objofCustomeInfoPage.getErroMessage();
        Assert.assertEquals(actulText, expectedText);

    }

}
