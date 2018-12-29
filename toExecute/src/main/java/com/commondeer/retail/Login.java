package com.commondeer.retail;

//import com.util.xlsx.reader.MyDataReader;
import main.java.ApplicationPageBase;
import main.java.ForEveryClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    public void loginfunc() {

//        Login.click();
//        String Ltitle = logInTitle.getText();
//        Assert.assertEquals("LOGIN",Ltitle);
//        System.out.println("Title Matched");
//        emailBox.sendKeys(loginEmail);
//        passwordBox.sendKeys(loginEmail);
//        logInBtn.click();
////        cookies.click();
////        loginSumbitBtn.click();


    }


}
