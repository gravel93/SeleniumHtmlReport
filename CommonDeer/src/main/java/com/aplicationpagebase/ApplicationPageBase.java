package com.aplicationpagebase;

import main.java.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reporting.TestLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class ApplicationPageBase extends BrowserDriver {
        /*
         * @author Jahidul Islam
         * All commonly used helper methods should be created here
         *
         * */
        String pageUrl;



        //return status of link if it is enabled
        public static boolean isEnableStatus(WebDriver driver, WebElement web) {
            boolean en = web.isEnabled();
            return en;
        }

        public static boolean isDisplayed(WebElement web,String webName){
            boolean isDis = web.isDisplayed();
            TestLogger.log("Checking element " + webName);
            System.out.println("Logo is verified");
            return isDis;
        }

        public static void sendKeys(WebElement webElement, String webElementName, String keys){
            webElement.clear();
            TestLogger.log("Sending " + keys + " to " + webElementName);
            webElement.sendKeys(keys);
            TestLogger.log("Keys Sent to " + webElementName);
        }

        public static String getText(WebElement webElement, String webElementName){

            TestLogger.log("Getting Text from " + webElementName);
            String actualText =  webElement.getText();
            TestLogger.log("Actual text: " + actualText);

            return actualText;

        }
        public static void click(WebElement webElement, String webElementName){
            TestLogger.log("Click " + webElementName );
            webElement.click();
            TestLogger.log("Clicked " + webElementName);
        }

    public static void hoverOver( WebElement webElement,String WebElementName){
        Actions actions = new Actions(driver);
        TestLogger.log("HoveringOver ON " + WebElementName);
        actions.moveToElement(webElement).build().perform();
    }



    public static void assertExpection(String function, String WebElementName, String expected){
            String ExpectedText = expected;
            TestLogger.log("Getting text from " + WebElementName);
            Assert.assertEquals(expected,function);
            System.out.println("Text Matched");
    }



    public static Properties loadProperties() throws IOException {
            Properties prop = new Properties();
            File filepath = new File(System.getProperty("user.dir") +  "/src/test/resources/secret.properties");
            InputStream ism = new FileInputStream(filepath.getAbsoluteFile());
            prop.load(ism);
            ism.close();
            return prop;
        }


    public static void ExplicitWait(WebDriver driver,WebElement webElement,int howMuchSecond){
        WebDriverWait wait = new WebDriverWait(driver,howMuchSecond);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }





}

