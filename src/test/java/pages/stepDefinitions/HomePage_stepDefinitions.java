package pages.stepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class HomePage_stepDefinitions {

    HomePage homePage;

    @Given("User launches the Zero Bank Home page")
    public void user_launches_the_zero_bank_home_page() {
        homePage = new HomePage();
        homePage.driverGet(ConfigurationReader.getProperty("project_url"));
    }


    @And("User clicks the SignIn button on the Navbar")
    public void userClicksTheSignInButtonOnTheNavbar() {
        homePage.clickSignInBtn();
    }


    @Then("User should navigate to the Home page")
    public void user_should_navigate_to_the_home_page() {
        Assert.assertEquals("HOME", homePage.getHomePageTitleText());
    }

    @Then("User logout from account")
    public void userLogoutFromAccount() {
        homePage.clickUserAccountDropDownBtn();
        homePage.clickUserLogoutBtn();
    }

    @Given("User is on Online Banking page")
    public void userIsOnOnlineBankingPage() {
        homePage.clickOnlineBankingBtn();
    }

}
