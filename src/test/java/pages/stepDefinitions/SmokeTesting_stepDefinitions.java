package pages.stepDefinitions;

import Utilities.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class SmokeTesting_stepDefinitions {

    @After(order = 2)
    public void generateReport(Scenario scenario) {
        ExcelUtilities.setRowsAndColumns(
                "src/test/Reports/SmokeTest/smokeTestReport.xlsx",
                "SmokeTesting",
                scenario.getStatus().toString(),
                scenario.getName());
    }
}
