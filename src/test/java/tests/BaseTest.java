package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;

    protected static String loginPageUrl = "https://opensource-demo.orangehrmlive.com/";

    @BeforeAll
    public static void beforeAllTests() {
        setChromeDriverPath();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void afterAllTests() {
        driver.quit();
    }

    private static void setChromeDriverPath() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
    }
}