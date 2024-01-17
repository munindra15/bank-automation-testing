package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "/pages",
//        tags = "@ZEROBANK_TRANSFER_FUNDS",
        tags = "@ZEROBANK_PAY_BILLS",
        plugin = {"pretty"},
        monochrome = true,
        publish = false)
public class Runner {
}
