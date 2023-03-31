package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class AbstractAcceptance {

    protected WebDriver driver;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    @Parameters("propertyFileLang")
    public void setupTest(String parameterValue) {
        PropertiesFile.loadProperties(parameterValue);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





