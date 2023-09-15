package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user-identifier-input")
    public WebElement email;

    @FindBy(id = "password-input")
    public WebElement password;

    @FindBy(id = "submit-button")
    public WebElement siginbutton;

    @FindBy(id = "form-message-general")
    public WebElement errormessage;
}
