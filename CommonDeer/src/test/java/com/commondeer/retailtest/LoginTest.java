package com.commondeer.retailtest;

import com.commondeer.retail.Login;
import com.util.xlsx.reader.MyDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest extends Login {

    Login objLogin = null;


    @BeforeMethod
    public void initializationOfElements() {

        objLogin = PageFactory.initElements(driver, com.commondeer.retail.Login.class);
    }


    @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File(System.getProperty("user.dir") +  "/testData/TestData.xlsx");
        MyDataReader dr = new MyDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());
        String[][] data = dr.getExcelSheetData("Sheet3");
        return data;
    }

    @Test(dataProvider = "DP")
    public  void invalidSignin(String email, String password, String expectedErroMessage){

        Login.click();
        objLogin.login(email, password);
//        String expectedText = expectedErroMessage;
//        String actulText = objLogin.getErroMessage();
//        Assert.assertEquals(actulText, expectedText);


    }

    }


