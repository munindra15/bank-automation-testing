package pages.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.NavigationBar;

public class NavigationBar_stepDefinitions {

    NavigationBar navigationBar = new NavigationBar();

    @Given("User clicks on Online Banking page")
    public void userClicksOnOnlineBankingPage() {
        navigationBar.clickOnlineBankingMenu();
    }

    @And("User clicks on Feedback page")
    public void userClicksOnFeedbackPage() {
        navigationBar.clickFeedbackBtn();
    }
}
