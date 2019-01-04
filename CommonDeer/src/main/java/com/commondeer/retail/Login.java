package com.commondeer.retail;

//import com.util.xlsx.reader.MyDataReader;
import com.aplicationpagebase.ApplicationPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends ApplicationPageBase {


    public static String loginEmail = "1madman@bk.ru";
    public static String loginPassword = "qwer1234";

    @FindBy(xpath = "//h1[text()='Login']")
    private WebElement logInTitle;

    @FindBy(xpath = "//a[@id='customer_login_link'][1]")
    public static WebElement Login;

    @FindBy(css = "input#CustomerEmail")
    private WebElement emailBox;

    @FindBy(css = "input#CustomerPassword")
    private WebElement passwordBox;

    @FindBy (xpath = "//input[@value='Sign In']")
    private WebElement logInBtn;

    @FindBy(css = "div.recaptcha-checkbox-borderAnimation")
    private  WebElement cookies;

//    @FindBy(xpath = "//input[@value='Submit']")
//    private WebElement loginSumbitBtn;

    @FindBy(xpath = "//li[contains(text(),'Invalid login credentials.')]")
    public WebElement errorMessage;




    public Login login(String email, String password){

        sendKeys(emailBox, "emailBox", email);
        sendKeys(passwordBox,"passwordBox", password);
        click(logInBtn,"logInBtn");
//        click(cookies,"cookies");
////        click(loginSumbitBtn,"loginSumbitBtn");

        return new Login();

    }


    public String getErroMessage(){

        String actualText = getText(errorMessage,"errorMessage");

        return actualText;
    }




}
