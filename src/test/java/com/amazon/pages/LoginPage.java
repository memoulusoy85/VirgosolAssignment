package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage{

    public LoginPage() { PageFactory.initElements(Driver.get(), this);}

     @FindBy(id="ap_email")
    public WebElement inputEmail;

     @FindBy(id="continue")
    public WebElement btnEmail;

    @FindBy(id="ap_password")
    public WebElement inputPassword;

    @FindBy(id="signInSubmit")
    public WebElement btnSignIn;


    public void login(){

        inputEmail.clear();
        inputEmail.sendKeys(ConfigurationReader.get("amazon_userName"));
        btnEmail.click();

        inputPassword.clear();
        inputPassword.sendKeys(ConfigurationReader.get("amazon_password"));
        btnSignIn.click();
        Log.info("login() method , SUCCESS");

    }

}
