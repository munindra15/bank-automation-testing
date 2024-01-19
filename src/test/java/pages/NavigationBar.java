package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends BrowserUtilities {

    @FindBy(id = "homeMenu")
    private WebElement homeBtn;

    @FindBy(id = "onlineBankingMenu")
    private WebElement onlineBankingBtn;

    @FindBy(id = "feedback")
    private WebElement feedbackBtn;

    public NavigationBar(){
        PageFactory.initElements(driver, this);
    }

    public void clickHomeBtn(){
        homeBtn.click();
    }

    public void clickOnlineBankingMenu(){
        onlineBankingBtn.click();
    }

    public void clickFeedbackBtn(){
        feedbackBtn.click();
    }
}
