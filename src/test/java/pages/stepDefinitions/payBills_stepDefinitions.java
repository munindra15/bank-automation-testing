package pages.stepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PayBills;

import java.util.Date;

public class payBills_stepDefinitions {

    PayBills payBills = new PayBills();
    Date dateObj = new Date();

    @And("User is on the Pay Saved Payee page")
    public void userIsOnThePaySavedPayeePage() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_pay_saved_payee_title"), payBills.getPaySavedPayeeTitle());
    }

    @When("User selects {string} from Payee dropdown list")
    public void userSelectsFromPayeeDropdownList(String arg0) {
        payBills.selectPaySavedPayeeByVisibleText(arg0);
    }

    @And("User selects {string} from Account dropdown list")
    public void userSelectsFromAccountDropdownList(String arg0) {
        payBills.selectPaySavedPayeeAccountByVisibleText(arg0);
    }

    @Then("User enters amount in the Payee Amount input")
    public void userEntersAmountInThePayeeAmountInput() {
        payBills.setPaySavedPayeeAmountInput(ConfigurationReader.getProperty("pay_bills_sample_amount"));
    }

    @And("User enters {string} in the Date input")
    public void userEntersDateInTheDateInput(String arg0) {
        payBills.setSavedPayeeDateInput(arg0);
    }


    @And("User enters description in the Payee Description box")
    public void userEntersDescriptionInThePayeeDescriptionBox() {
        payBills.setPaySavedPayeeDescriptionInput(ConfigurationReader.getProperty("pay_bills_description_input_text"));
    }

    @Then("User clicks on the Pay button")
    public void userClicksOnThePayButton() {
        payBills.clickPayPayeeBtn();
    }


    @And("Successfully paid to payee message is displayed")
    public void successfullyPaidToPayeeMessageIsDisplayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_successful_payment_text"), payBills.getPayBillsSuccessfulText());
    }

    @And("User is on the Add New Payee page")
    public void userIsOnTheAddNewPayeePage() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_add_new_payee_title"), payBills.getAddNewPayeeTitle());
    }

    @Then("User enters {string} in the Payee Name input")
    public void userEntersPayeeNameInTheNameInput(String arg0) {
        payBills.setNewPayeeNameInput(arg0);
    }

    @And("User enters {string} in the Payee Address box")
    public void userEntersPayeeAddressInTheAddressBox(String arg0) {
        payBills.setNewPayeeAddressInput(arg0);
    }

    @And("User enters {string} in the account input")
    public void userEntersAccountInTheAccountInput(String arg0) {
        payBills.setNewPayeeAccountNumberInput(arg0);
    }

    @And("User enters {string} in the Payee Details input")
    public void userEntersPayeeDetailsInTheDetailsInput(String arg0) {
        payBills.setNewPayeeDetailsInput(arg0);
    }

    @Then("User clicks on the Add button")
    public void userClicksOnTheAddButton() {
        payBills.clickNewPayeeBtn();
    }

    @And("Successfully new Payee message is displayed")
    public void successfullyNewPayeeMessageIsDisplayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_add_new_payee_successful_text"), payBills.getAddNewPayeeSuccessfulText());
    }

    @And("User clicks on the Add New Payee link")
    public void userClicksOnTheAddNewPayeeLink() {
        payBills.clickAddNewPayeeBtn();
    }

    @Then("User clicks on the Purchase Foreign Currency link")
    public void userClicksOnThePurchaseForeignCurrencyLink() {
        payBills.clickPurchaseForeignCurrencyBtn();
    }

    @And("User is on the Purchase Foreign Currency page")
    public void userIsOnThePurchaseForeignCurrencyPage() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_purchase_foreign_currency_title"), payBills.getPurchaseForeignCurrencyTitle());
    }

    @Then("User selects {string} from the list")
    public void userSelectsFromTheList(String arg0) {
        payBills.selectForeignCurrencyByVisibleText(arg0);
    }

    @And("User enters Amount in the Foreign Currency amount input")
    public void userEntersAmountInTheForeignCurrencyAmountInput() {
        payBills.setForeignCurrencyAmountInput("200");
    }

    @And("User selects {string} by clicking radio button")
    public void userSelectsByClickingRadioButton(String arg0) {
        payBills.selectSellCurrencyByArgument(arg0);
    }

    @Then("User clicks on the Calculate Costs")
    public void userClicksOnTheCalculateCosts() {
        payBills.clickCalculateCosts();
    }

    @And("User clicks on the Purchase button")
    public void userClicksOnThePurchaseButton() {
        payBills.clickPurchaseForeignCurrencyCashBtn();
    }

    @And("Successfully Foreign Currency Cash Purchase message is displayed")
    public void successfullyForeignCurrencyCashPurchaseMessageIsDisplayed() {
        Assert.assertEquals(ConfigurationReader.getProperty("pay_bills_purchase_foreign_currency_successful_text"), payBills.getSuccessfulForeignCurrencyPurchaseSuccessfulText());
    }
}
