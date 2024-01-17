package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PayBills extends BrowserUtilities {

    @FindBy(linkText = "Pay Saved Payee")
    private WebElement paySavedPayeeBtn;
    @FindBy(xpath = ".//li/a[contains(text(),'Add New Payee')]")
    private WebElement addNewPayeeBtn;
    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement purchaseForeignCurrencyBtn;

    //  PAY SAVED PAYEE

    @FindBy(className = "board-header")
    private WebElement paySavedPayeePageTitle;
    @FindBy(id = "alert_content")
    private WebElement payBillsSuccessfulText;
    @FindBy(id = "sp_payee")
    private WebElement paySavedPayeeDropdown;
    @FindBy(id = "sp_account")
    private WebElement paySavedAccountDropdown;
    @FindBy(id = "sp_amount")
    private WebElement paySavedPayeeAmountInput;
    @FindBy(id = "sp_date")
    private WebElement paySavedDateInput;
    @FindBy(id = "sp_description")
    private WebElement paySavedDescriptionInput;
    @FindBy(id = "pay_saved_payees")
    private WebElement payPayeeBtn;


    //  ADD NEW PAYEE

    @FindBy(xpath = ".//div[@id='ui-tabs-2']/h2")
    private WebElement addNewPayeeTitle;
    @FindBy(xpath = ".//div[contains(@class,'alert-success')]/div[@id='alert_content']")
    private WebElement addNewPayeeSuccessfulText;
    @FindBy(id = "np_new_payee_name")
    private WebElement addNewPayeeNameInput;
    @FindBy(id = "np_new_payee_address")
    private WebElement addNewPayeeAddressInput;
    @FindBy(id = "np_new_payee_account")
    private WebElement addNewPayeeAccountInput;
    @FindBy(id = "np_new_payee_details")
    private WebElement addNewPayeeDetailsInput;
    @FindBy(id = "add_new_payee")
    private WebElement addPayeeBtn;


    //  PURCHASE FOREIGN CURRENCY
    @FindBy(id = "pc_currency")
    private WebElement currencyDropdownElement;
    @FindBy(id = "pc_amount")
    private WebElement amountInput;
    @FindBy(id = "pc_inDollars_true")
    private WebElement usdConversionRadioBtn;
    @FindBy(id = "pc_inDollars_false")
    private WebElement selectedCurrencyRadioBtn;
    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCostsBtn;
    @FindBy(id = "sp_sell_rate")
    private WebElement sellRate;
    @FindBy(id = "pc_conversion_amount")
    private WebElement convertedAmountLabel;

    Select selectObj;


    public PayBills() {
        PageFactory.initElements(driver, this);
    }

    public void clickPaySavedPayeeBtn() {
        paySavedPayeeBtn.click();
    }

    public void clickAddNewPayeeBtn() {
        addNewPayeeBtn.click();
    }

    public void clickPurchaseForeignCurrencyBtn() {
        purchaseForeignCurrencyBtn.click();
    }

//  PAY SAVED PAYEE

    public void selectPaySavedPayeeByVisibleText(String value) {
        selectObj = new Select(paySavedPayeeDropdown);
        List<WebElement> optionsList = selectObj.getOptions();
        for (WebElement e : optionsList) {
            if (e.getText().toLowerCase().contains(value.toLowerCase())) {
                selectObj.selectByVisibleText(e.getText());
            }
        }
    }

    public void selectPaySavedPayeeAccountByVisibleText(String value) {
        selectObj = new Select(paySavedAccountDropdown);
        List<WebElement> optionsList = selectObj.getOptions();
        for (WebElement e : optionsList) {
            if (e.getText().toLowerCase().contains(value.toLowerCase())) {
                selectObj.selectByVisibleText(e.getText());
            }
        }
    }

    public void setPaySavedPayeeAmountInput(String  amount) {
        paySavedPayeeAmountInput.clear();
        paySavedPayeeAmountInput.sendKeys(amount);
    }

    public void setSavedPayeeDateInput(String date) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        paySavedDateInput.clear();
        paySavedDateInput.sendKeys(date);
    }

    public void setPaySavedPayeeDescriptionInput(String description) {
        paySavedDescriptionInput.clear();
        paySavedDescriptionInput.sendKeys(description);
    }

    public void clickPayPayeeBtn(){
        payPayeeBtn.click();
    }

    public String getPayBillsSuccessfulText() {
        return payBillsSuccessfulText.getText();
    }

    //  ADD NEW PAYEE
    public void setNewPayeeNameInput(String payeeName) {
        addNewPayeeNameInput.clear();
        addNewPayeeNameInput.sendKeys(payeeName);
    }

    public void setNewPayeeAddressInput(String payeeAddress) {
        addNewPayeeAddressInput.clear();
        addNewPayeeAddressInput.sendKeys(payeeAddress);
    }

    public void setNewPayeeAccountNumberInput(String payeeAccountNumber) {
        addNewPayeeAccountInput.clear();
        addNewPayeeAccountInput.sendKeys(payeeAccountNumber);
    }

    public void setNewPayeeDetailsInput(String payeeDetails) {
        addNewPayeeDetailsInput.clear();
        addNewPayeeDetailsInput.sendKeys(payeeDetails);
    }

    public void clickNewPayeeBtn() {
        addPayeeBtn.click();
    }

    public String getAddNewPayeeSuccessfulText() {
        return addNewPayeeSuccessfulText.getText();
    }


    //  PURCHASE FOREIGN CURRENCY
    public void selectForeignCurrencyByValue(String value) {
        Select currencyDropdown = new Select(currencyDropdownElement);
        currencyDropdown.selectByValue(value.toUpperCase());
    }

    public void selectForeignCurrencyByIndex(int index) {
        Select currencyDropdown = new Select(currencyDropdownElement);
        currencyDropdown.selectByIndex(index);
    }

    public void setForeignCurrencyAmountInput(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickUSDAsSell() {
        usdConversionRadioBtn.click();
    }

    public void clickSelectedCurrencyAsSell() {
        selectedCurrencyRadioBtn.click();
    }

    public void clickCalculateCosts() {
        calculateCostsBtn.click();
    }

    public String getCurrency() {
        return currencyDropdownElement.getText();
    }

    public String getSellRate() {
        return sellRate.getText();
    }

    public String getConversionAmount() {
        return amountInput.getAttribute("value");
    }

    public String getConvertFromCurrency() {
        if (usdConversionRadioBtn.isSelected()) {
            return "USD";
        } else {
            return getCurrency();
        }
    }

    public String getConvertedAmount() {
        return convertedAmountLabel.getText();
    }

    public String getPaySavedPayeeTitle() {
        return paySavedPayeePageTitle.getText();
    }

    public String getAddNewPayeeTitle() {
        return addNewPayeeTitle.getText();
    }
}
