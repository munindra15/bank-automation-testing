package pages.stepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TransferFunds;

public class TransferFunds_stepDefinitions {

    TransferFunds transferFunds = new TransferFunds();

    @When("User selects {string} in from account dropdown")
    public void userSelectsInFromAccountDropdown(String arg0) {
        transferFunds.selectAccountFromSelect(arg0);
    }

    @And("User selects {string} in to account dropdown")
    public void userSelectsInToAccountDropdown(String arg0) {
        transferFunds.selectAccountToSelect(arg0);
    }

    @Then("User enters amount in the Amount input")
    public void userEntersAmountInTheAmountInput() {
        transferFunds.setAmountInput(ConfigurationReader.getProperty("transfer_funds_sample_amount"));
    }

    @And("User enters description in the Description box")
    public void userEntersDescriptionInTheDescriptionBox() {
        transferFunds.setDescriptionInput(ConfigurationReader.getProperty("transfer_funds_description_input_text"));
    }

    @Then("User clicks on the Continue button")
    public void userClicksOnTheContinueButton() {
        transferFunds.clickContinueBtn();
    }

    @And("Verify money transfer page is displayed")
    public void verifyMoneyTransferPageIsDisplayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("transfer_funds_verify_page_title"), transferFunds.getVerifyTransferFundTitleText());
    }

    @Then("User clicks on the Submit button")
    public void userClicksOnTheSubmitButton() {
        transferFunds.clickSubmitBtn();
    }

    @And("Successfully transfer message is displayed")
    public void SuccessfullyTransferMessageIsDisplayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("transfer_funds_successful_text"), transferFunds.getSuccessfulMessageText());
    }
}
