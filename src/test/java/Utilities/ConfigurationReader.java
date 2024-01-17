package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static String getProperty(String propertyKey) {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : config.stringPropertyNames()) {
            if (key.equals(propertyKey)) {
                return config.getProperty(key);
            }
        }

        return "Invalid property Key!!";
    }
}
