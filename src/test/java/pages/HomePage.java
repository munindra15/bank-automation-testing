package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BrowserUtilities {

    @FindBy(id = "signin_button")
    private WebElement signInBtn;

    @FindBy(id = "transfer_funds_link")
    private WebElement transferFundsBtn;

    @FindBy(xpath = "//li[@class='dropdown']/a[2]")
    private WebElement userMenuBtn;

    @FindBy(id = "logout_link")
    private WebElement logoutBtn;

    @FindBy(id = "online-banking")
    private WebElement moreServicesBtn;

    @FindBy(id = "onlineBankingMenu")
    private WebElement onlineBanking;

    @FindBy(xpath = ".//div//li[@class='active']//*[contains(text(),'Home')]")
    private WebElement homePageTitle;

    @FindBy(className = "icon-user")
    private WebElement userAccountDropDownBtn;

    @FindBy(id = "logout_link")
    private WebElement userLogoutBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public void clickTransferFundsBtn() {
        transferFundsBtn.click();
    }

    public void clickLogoutBtn() {
        userMenuBtn.click();
        logoutBtn.click();
    }

    public void clickMoreServicesBtn() {
        moreServicesBtn.click();
    }

    public void clickOnlineBankingBtn(){
        onlineBanking.click();
    }


    public String getHomePageTitleText() {
        return homePageTitle.getText();
    }

    public void clickUserAccountDropDownBtn(){
        userAccountDropDownBtn.click();
    }

    public void clickUserLogoutBtn(){
        userLogoutBtn.click();
    }
}
