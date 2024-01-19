package pages;

import Utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage extends BrowserUtilities {

    @FindBy(id = "feedback-title")
    private WebElement feedbackPageTitle;

    public FeedbackPage(){
        PageFactory.initElements(driver, this);
    }

    public String getFeedbackPageTitle(){
        return feedbackPageTitle.getText();
    }
}
