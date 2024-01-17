package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummary extends BrowserUtilities {

    private WebDriver driver;

    @FindBy(xpath = ".//h2[contains(text(),'Cash Accounts')]/following::tbody//a[contains(text(),'Savings')]")
    private WebElement savingsLink;

    @FindBy(xpath = ".//h2[contains(text(),'Investment Accounts')]/following::tbody//a[contains(text(),'Brokerage')]")
    private WebElement brokerageLink;

    @FindBy(xpath = ".//h2[contains(text(),'Credit Accounts')]/following::tbody//a[contains(text(),'Checking')]")
    private WebElement checkingLink;

    @FindBy(xpath = ".//h2[contains(text(),'Credit Accounts')]/following::tbody//a[contains(text(),'Credit Card')]")
    private WebElement creditCardLink;

    @FindBy(xpath = ".//h2[contains(text(),'Loan Accounts')]/following::tbody//a[contains(text(),'Loan')]")
    private WebElement loanLink;

    @FindBy(xpath = ".//td/a[contains(text(),'Checking')]/following::td")
    private WebElement creditCardNumber;

    public AccountSummary() {
        PageFactory.initElements(driver, this);
    }

    public void clickSavingsLink() {
        savingsLink.click();
    }

    public void clickBrokerageLink() {
        brokerageLink.click();
    }

    public void clickCheckingLink() {
        checkingLink.click();
    }

    public void clickCreditCardLink() {
        creditCardLink.click();
    }

    public void clickLoanLink(){
        loanLink.click();
    }

}
