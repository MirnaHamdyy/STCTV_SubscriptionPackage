package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesFile {
    protected static Properties properties = new Properties();

    public static void loadProperties(String environment) {

        String propertiesFileName = System.getProperty("user.dir") + "/src/test/resources/data_"+ environment + ".properties";
        try (FileInputStream fileInputStream = new FileInputStream(propertiesFileName)) {
            properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + propertiesFileName, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
