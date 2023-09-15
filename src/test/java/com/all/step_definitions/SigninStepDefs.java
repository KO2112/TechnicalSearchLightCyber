package com.all.step_definitions;

import com.all.pages.MainPage;
import com.all.pages.SignInPage;
import com.all.pages.YourAccountPage;
import com.all.utilities.BrowserUtils;
import com.all.utilities.ConfigurationReader;
import com.all.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SigninStepDefs {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SignInPage signInPage = new SignInPage();
    Actions actions = new Actions(Driver.getDriver());
    MainPage mainPage = new MainPage();
    Faker faker  = new Faker();
    YourAccountPage yourAccountPage = new YourAccountPage();
    @Given("user navigates to BBC website and clicks sign in")
    public void user_navigates_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website.url"));
        BrowserUtils.sleep(1);
        mainPage.signilogo.click();
    }
    @Given("User logs in")
    public void user_logs_in() {
        signInPage.email.sendKeys("yagizorhan277@gmail.com");
        signInPage.password.sendKeys("yagizorhan.");
        signInPage.siginbutton.click();

    }
    @Then("user should be on the home page")
    public void user_should_be_on_the_dashboard() {
        String Title = Driver.getDriver().getTitle();
        Assert.assertEquals(Driver.getDriver().getTitle(),Title);
        Driver.closeDriver();
    }
    @And("User enters unvalid credentials")
    public void userEntersUnvalidCredentials() {
        signInPage.email.sendKeys(faker.internet().safeEmailAddress());
        signInPage.password.sendKeys(faker.internet().password());
        signInPage.siginbutton.click();
    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(signInPage.errormessage.isDisplayed());
    }

    @And("user navigates to your account page and clicks settings")
    public void userNavigatesToYourAccountPage() {
        BrowserUtils.sleep(1);
        mainPage.youraccountbutton.click();
        yourAccountPage.settingsbutton.click();
    }

    @And("user changes their postcode")
    public void userChangesTheirPostcode() {
        BrowserUtils.sleep(1);
        yourAccountPage.editubtton.click();
        BrowserUtils.sleep(1);
        yourAccountPage.editpostcodearea.click();
        yourAccountPage.editpostcodearea.sendKeys(Keys.CONTROL + "a");
        yourAccountPage.editpostcodearea.sendKeys(Keys.DELETE);
        BrowserUtils.sleep(1);
        yourAccountPage.editpostcodearea.sendKeys("LE18 2EF");
        yourAccountPage.saveandcontinuebutton.click();
    }

    @Then("new postcode should appear")
    public void newPostcodeShouldAppear() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(yourAccountPage.successmessage.isDisplayed());
        Driver.getDriver().quit();
    }
}
