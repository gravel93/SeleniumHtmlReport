package com.commondeer.retailtest;

import api.GoogleSheetReader;
import com.commondeer.retail.Login;
import com.aplicationpagebase.ApplicationPageBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class GoogleSheetForLogInTest  extends ApplicationPageBase {

        Login objOfLogiPage = null;





    @BeforeMethod
    public void initializationOfElements() {

        objOfLogiPage= PageFactory.initElements(driver, Login.class);

    }


    @DataProvider(name = "googleSheet")
    public Object[][] getTestDataFromGoogleSheet() throws IOException {

        Properties properties = loadProperties();
        String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
        String range = properties.getProperty("GOOGLE.range");
        /**
         *
         * Two ways to convert  List to Array in GoogleSheetReader.java class
         * Both method will give data from Google Sheet
         *
         * */
        //  String[][] data = GoogleSheetReader.getSpreadSheetRecordsToSupplyDataProvider(spreadsheetId, range);
        String[][] data = GoogleSheetReader.getSpreadSheetRecordsToSupplyDataProviderAlternativeWay(spreadsheetId,range);
        return data;


    }


    @Test(dataProvider = "googleSheet")
    public  void invalidSignin(String Email, String Password, String expectedErroMessage){


        objOfLogiPage.Login.click();
        objOfLogiPage.login(Email, Password);



    }

    @Test(enabled = false)
    public  void invalidSigninByGoogleSheetApi() throws IOException {

        Properties properties = loadProperties();
        String spreadsheetId = properties.getProperty("GOOGLE.spreadsheetId");
        String range = properties.getProperty("GOOGLE.range");
        TestLogger.log("Using Sheet Number " + range.charAt(5) + " and fields range  " + range.substring(6));
        List<List<Object>> getRecords = GoogleSheetReader.getSpreadSheetRecords(spreadsheetId, range);



        for (List cell : getRecords) {

            objOfLogiPage.login(cell.get(0).toString(), cell.get(1).toString());

            String expectedText = cell.get(2).toString();

            System.out.println(expectedText);

        }
    }







}
