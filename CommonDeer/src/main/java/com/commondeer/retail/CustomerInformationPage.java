package com.commondeer.retail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInformationPage extends ShoppingCard {

    Login objOfloGin = new Login();

    @FindBy(css = "input#checkout_email")
    private WebElement customerPageemail;
    @FindBy (css = "input#checkout_shipping_address_first_name")
    private WebElement firstName;
    @FindBy(css = "input#checkout_shipping_address_last_name")
    private WebElement lastname;
    @FindBy(css = "input#checkout_shipping_address_address1")
    private WebElement address;
    @FindBy(css = "input#checkout_shipping_address_city")
    private  WebElement city;
    @FindBy(css = "select#checkout_shipping_address_province")
    private WebElement province;
    @FindBy(xpath = "//option[text()='New York']")
    private WebElement newYork;
    @FindBy(css = "input#checkout_shipping_address_zip")
    private WebElement zipcode;
    @FindBy (css = "input#checkout_shipping_address_phone")
    private WebElement phoneNumber;
    @FindBy (xpath = "//button[@class='step__footer__continue-btn btn ']")
    private WebElement submitBtn;

    @FindBy(css = "p#error-for-reduction_code")
    public  WebElement promoCode;

    @FindBy(css = "#checkout_reduction_code")
    public WebElement enterPromoCode;

    @FindBy(xpath = "//button[@class='field__input-btn btn']")
    public WebElement btnApply;

    @FindBy(css = "#error-for-reduction_code")
    public WebElement promoerrorMessage;



    public void customerFillInfoPage () throws InterruptedException {
        checkOutFunc();
        customerPageemail.sendKeys(objOfloGin.loginEmail);
        firstName.sendKeys("Ali");
        lastname.sendKeys("baba");
        address.sendKeys("21-25 miyagi Street");
        city.sendKeys("New York");
        province.click();
        newYork.click();
        zipcode.sendKeys("11321");
        phoneNumber.sendKeys("1234567897");
        submitBtn.click();

    }

    public CustomerInformationPage invalidPromoCode(String promoCode){
        sendKeys(enterPromoCode,"enterPromoCode",promoCode);
        click(btnApply,"btnApply");
        return new CustomerInformationPage();
    }

    public String getErroMessage(){

        String actualText = getText(promoerrorMessage,"errorMessage");

        return actualText;
    }

}
