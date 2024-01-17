package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TransferFunds extends BrowserUtilities {

    @FindBy(id = "tf_fromAccountId")
    private WebElement accountFromSelect;

    @FindBy(id = "tf_toAccountId")
    private WebElement accountToSelect;

    @FindBy(id = "tf_amount")
    private WebElement amountInput;

    @FindBy(id = "tf_description")
    private WebElement descriptionInput;

    @FindBy(id = "btn_submit")
    private WebElement continueBtn;
    private Select selectObject;

    @FindBy(xpath = ".//h2[@class='board-header'][contains(text(),'Verify')]")
    private WebElement verifyTransferFundTitle;

    @FindBy(id = "btn_submit")
    private WebElement submitBtn;

    @FindBy(className = "alert-success")
    private WebElement fundTransferSuccessfulText;

    public TransferFunds() {
        PageFactory.initElements(driver, this);
    }
    
    public void selectAccountFromSelect(String accountFromString){
        selectObject = new Select(accountFromSelect);
        List<WebElement> optionsList = selectObject.getOptions();

        for (WebElement e : optionsList){
            if(e.getText().toLowerCase().contains(accountFromString.toLowerCase()))
            {
                selectObject.selectByVisibleText(e.getText());
            }
        }
    }

    public void selectAccountToSelect(String accountToString){
        selectObject = new Select(accountToSelect);

        List<WebElement> optionsList = selectObject.getOptions();

        for (WebElement e : optionsList){
            if(e.getText().toLowerCase().contains(accountToString.toLowerCase()))
            {
                selectObject.selectByVisibleText(e.getText());
            }
        }
    }

    public void setAmountInput(String amount){
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void setDescriptionInput(String description){
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

    public String getVerifyTransferFundTitleText() {
        return verifyTransferFundTitle.getText();
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public String getSuccessfulMessageText(){
        return fundTransferSuccessfulText.getText();
    }
}
