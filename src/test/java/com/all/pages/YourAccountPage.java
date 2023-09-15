package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    public YourAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settingsbutton;

    @FindBy(xpath = "//a[contains(@href, '/account/settings/edit/location') and .//span[text()='Edit']]")
    public WebElement editubtton;

    @FindBy(xpath = "//input[@id='new-postcode-input']")
    public WebElement editpostcodearea;

    @FindBy(xpath = "//button[text()='Save and continue' and contains(@class, 'button')]")
    public WebElement saveandcontinuebutton;

    @FindBy(xpath = "//p[text()='Make sure your location is up to date so you can keep getting relevant local information online.']")
    public WebElement successmessage;
}
