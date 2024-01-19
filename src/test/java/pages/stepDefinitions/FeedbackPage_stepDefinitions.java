package pages.stepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.FeedbackPage;

public class FeedbackPage_stepDefinitions {

    FeedbackPage feedbackPage = new FeedbackPage();

    @And("User is on Feedback page")
    public void userIsOnFeedbackPage() {
        Assert.assertEquals(ConfigurationReader.getProperty("feedback_page_title"), feedbackPage.getFeedbackPageTitle());
    }
}
