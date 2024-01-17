package pages.stepDefinitions;

import Utilities.BrowserUtilities;
import Utilities.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Hooks extends BrowserUtilities {
    @Before
    public void setup(){
        driverUtilities = getInstance();
        driver = driverUtilities.getDriver();
        maximizeWindow();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private String getPageName(Scenario scenario){
        String pageName = scenario.getName();
        if(pageName.contains("Account Activity")){
            return "Account Activity";
        } else if(pageName.contains("Account Summary")){
            return "Account Summary";
        } else if(pageName.contains("Online Banking")){
            return "Online Banking";
        } else if(pageName.contains("Pay Bills")){
            return "Pay Bills";
        } else if(pageName.contains("Transfer Funds")){
            return "Transfer Funds";
        }
        return "Unknown Page";
    }
    @After(order = 1)
    public void takeScreenShotOnFailure(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("PageName: " + getPageName(scenario));
            //String pageName = getPageName(scenario);
            String outputPath = "src/test/resources/Screenshot/";
            SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");
            Date date = new Date();
            screenShot(outputPath, scenario.getName()+";"+formatter.format(date));
        }
    }
}
