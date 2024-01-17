package pages.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnlineBankingPage;

public class OnlineBankingPage_stepDefinitions {

    OnlineBankingPage onlineBankingPage = new OnlineBankingPage();

    @And("User clicks on Transfer Funds page")
    public void userClicksOnTransferFundsPage() {
        onlineBankingPage.clickTransferFundsBtn();
    }

    @And("User clicks on Pay Bills link")
    public void userClicksOnPayBillsLink() {
        onlineBankingPage.clickPayBillsBtn();
    }
}
