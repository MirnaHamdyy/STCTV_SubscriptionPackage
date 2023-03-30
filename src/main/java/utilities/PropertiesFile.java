//package utilities;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.Properties;
//
//public class PropertiesFile {
//
//
//    static Properties prop = new Properties();
//
//        static {
//            try {
//                FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data_common.properties");
//                prop.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        public static String getProperty(String key) {
//            return prop.getProperty(key);
//        }
//
//}


package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesFile {
    protected static Properties properties;

    public static void loadProperties(String environment) {
        properties = new Properties();
        String propertiesFileName = System.getProperty("user.dir") + "/src/main/resources/data_"+ environment + ".properties";
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
