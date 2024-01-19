package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "/pages",
        tags = "@SmokeTest",
        plugin = {"pretty",
                "junit:src/test/Reports/SmokeTest/SmokeTest.junit",
                "json:src/test/Reports/SmokeTest/SmokeTest.json",
                "html:src/test/Reports/SmokeTest/SmokeTest.html"},
        monochrome = true,
        dryRun = false,
        publish = false)
public class SmokeTesting_runner {
}
