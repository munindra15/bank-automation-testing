package pages.stepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;

public class SignInPage_stepDefinitions {

    SignInPage signInPage = new SignInPage();


    @Given("User is on the signIn page")
    public void userIsOnTheSignInPage() {
        Assert.assertEquals(ConfigurationReader.getProperty("signIn_page_title"), signInPage.getSignInPageTitleText());
    }

    @When("User enters valid login and password")
    public void user_enters_valid_login_and_password() {
        signInPage.setUsernameInput(ConfigurationReader.getProperty("valid_username"));
        signInPage.setPasswordInput(ConfigurationReader.getProperty("valid_password"));

        Assert.assertFalse(signInPage.isUsernameInputEmpty());
        Assert.assertFalse(signInPage.isPasswordInputEmpty());
    }

    @When("User clicks the Sign In button")
    public void user_clicks_the_sign_in_button() {
        signInPage.clickSignInBtn();
    }

    @Then("User goes back when Browser error occurs")
    public void user_goes_back_when_browser_error_occurs() {
        signInPage.navigateBackward();
    }


    @When("User enters invalid login and password")
    public void user_enters_invalid_login_and_password() {
        signInPage.setUsernameInput(ConfigurationReader.getProperty("invalid_username"));
        signInPage.setPasswordInput(ConfigurationReader.getProperty("invalid_password"));
    }

    @Then("Wrong credentials error displayed")
    public void wrong_credentials_error_displayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("login_Invalid_credentials_error"), signInPage.getCredentialErrorText());
    }

    @When("User Enters invalid username")
    public void userEntersInvalidUsername() {
        signInPage.setUsernameInput(ConfigurationReader.getProperty("invalid_username"));
    }

    @And("User Enters valid Password")
    public void userEntersValidPassword() {
        signInPage.setPasswordInput(ConfigurationReader.getProperty("valid_password"));
    }

    @When("User enters valid username")
    public void userEntersValidUsername() {
        signInPage.setUsernameInput(ConfigurationReader.getProperty("valid_username"));
    }

    @When("User enters invalid password")
    public void userEntersInvalidPassword() {
        signInPage.setPasswordInput(ConfigurationReader.getProperty("invalid_password"));
    }

}
