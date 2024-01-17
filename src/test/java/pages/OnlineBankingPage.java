package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage extends BrowserUtilities {


    @FindBy(id = "account_summary_link")
    private WebElement accountSummaryBtn;
    @FindBy(id = "account_activity_link")
    private WebElement accountActivityBtn;
    @FindBy(id = "transfer_funds_link")
    private WebElement transferFundsBtn;
    @FindBy(id = "pay_bills_link")
    private WebElement payBillsBtn;

    public OnlineBankingPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickAccountSummaryBtn(){
        accountSummaryBtn.click();
    }
    public void clickAccountActivityBtn(){
        accountActivityBtn.click();
    }
    public void clickTransferFundsBtn(){
        transferFundsBtn.click();
    }
    public void clickPayBillsBtn(){
        payBillsBtn.click();
    }
}
