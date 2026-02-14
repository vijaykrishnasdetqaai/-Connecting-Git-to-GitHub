package com.automation.orangehrm.base;

import com.automation.orangehrm.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up WebDriver...");
        WebDriver driver = null;
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        logger.info("Browser: " + browser + ", Headless: " + headless);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        if (driver != null) {
            driverThreadLocal.set(driver);
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Navigating to URL: " + url);
            getDriver().get(url);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            logger.info("Tearing down WebDriver...");
            getDriver().quit();
            driverThreadLocal.remove();
        }
    }
}
