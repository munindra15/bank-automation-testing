package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BrowserUtilities {

    @FindBy(name = "user_login")
    private WebElement usernameInput;

    @FindBy(name = "user_password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement signInBtn;

    @FindBy(name = "user_remember_me")
    private WebElement keepMeSignedInBtn;

    @FindBy(className = "alert-error")
    private WebElement credentialErrorText;

    @FindBy(xpath = ".//h3")
    private WebElement signInPageTitle;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public void setUsernameInput(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public String getUsernameInputValue(){
        return usernameInput.getAttribute("value");
    }
    public Boolean isUsernameInputEmpty(){
        return usernameInput.getAttribute("value").isEmpty();
    }

    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public String getPasswordInputValue(){
        return passwordInput.getAttribute("value");
    }

    public boolean isPasswordInputEmpty() {
        return passwordInput.getAttribute("value").isEmpty();
    }

    public void clickKeepMeSignedInBtn() {
        keepMeSignedInBtn.click();
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public String getCredentialErrorText() {
        return credentialErrorText.getText();
    }

    public String getSignInPageTitleText() {
        return signInPageTitle.getText();
    }
}
