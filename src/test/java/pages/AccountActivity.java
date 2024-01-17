package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BrowserUtilities {

    private Select selectObject;

    @FindBy(linkText = "Show Transactions")
    private WebElement showTransactionsBtn;
    @FindBy(linkText = "Find Transactions")
    private WebElement findTransactionsBtn;

    @FindBy(id = "aa_accountId")
    private WebElement accountSelectList;

    @FindBy(xpath = ".//tbody/tr/td[1]")
    private List<WebElement> dateList;

    @FindBy(xpath = ".//tbody/tr/td[2]")
    private List<WebElement> descriptionList;

    @FindBy(xpath = ".//tbody/tr/td[3]")
    private List<WebElement> depositList;

    @FindBy(xpath = ".//tbody/tr/td[4]")
    private List<WebElement> withddrawalList;

    @FindBy(id = "aa_description")
    private WebElement descriptionInput;

    @FindBy(id = "aa_fromDate")
    private WebElement dateFromInput;

    @FindBy(id = "aa_toDate")
    private WebElement dateToInput;

    @FindBy(id = "aa_fromAmount")
    private WebElement amountFromInput;

    @FindBy(id = "aa_toAmount")
    private WebElement amountToInput;

    @FindBy(id = "aa_type")
    private WebElement typeSelect;

    @FindBy(xpath = ".//button[contains(text(),'Find')]")
    private WebElement findBtn;


    public AccountActivity() {
        PageFactory.initElements(driver, this);
    }

    public void clickShowTransactionsBtn(){
        showTransactionsBtn.click();
    }

    public void clickFindTransactionsBtn(){
        findTransactionsBtn.click();
    }

    public void selectAccountByName(String accountName) {
        selectObject = new Select(accountSelectList);
        selectObject.selectByVisibleText(accountName);
    }

    public void selectTransactionType(String transactionType) {
        selectObject = new Select(typeSelect);
        selectObject.selectByVisibleText(transactionType);
    }

    public void setDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void setDateFromInput(String dateFrom) {
        dateFromInput.clear();
        dateFromInput.sendKeys(dateFrom);
    }

    public void setDateToInput(String dateTo) {
        dateToInput.clear();
        dateToInput.sendKeys(dateTo);
    }

    public void setAmountFromInput(String amountFrom) {
        amountFromInput.clear();
        amountFromInput.sendKeys(amountFrom);
    }

    public void setAmountToInput(String amountTo) {
        amountToInput.clear();
        amountToInput.sendKeys(amountTo);
    }

    public void clickFindBtn() {
        findBtn.click();
    }

    public List<String> getTransactionDates() {
        List<String> dateStringList = new ArrayList<>();
        for (WebElement e : dateList) {
            dateStringList.add(e.getText());
        }
        return dateStringList;
    }

    public List<String> getTransactionDescription() {
        List<String> descriptionStringList = new ArrayList<>();
        for (WebElement e : descriptionList) {
            descriptionStringList.add(e.getText());
        }
        return descriptionStringList;
    }

    public List<String> getTransactionDeposit() {
        List<String> depositStringList = new ArrayList<>();
        for (WebElement e : depositList) {
            depositStringList.add(e.getText());
        }
        return depositStringList;
    }

    public List<String> getTransactionWithdraw() {
        List<String> withdrawStringList = new ArrayList<>();
        for (WebElement e : withddrawalList) {
            withdrawStringList.add(e.getText());
        }
        return withdrawStringList;
    }

}
