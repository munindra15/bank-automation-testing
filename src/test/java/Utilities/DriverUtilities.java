package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
    private static DriverUtilities driverUtilities;

    private WebDriver driver;

    protected DriverUtilities() {
        super();
    }

    public void resetDriver() {
        driverUtilities = null;
    }

    public static DriverUtilities getInstance() {
        if (driverUtilities == null) {
            driverUtilities = new DriverUtilities();
        }
        return driverUtilities;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private void createDriver() {
        String driverName = ConfigurationReader.getProperty("browser");
        System.out.println(ConfigurationReader.getProperty("browser"));

        switch (driverName) {
            case "google chrome":
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            case "msedge":
                this.driver = new EdgeDriver();
                break;
            default:
        }
    }


}
