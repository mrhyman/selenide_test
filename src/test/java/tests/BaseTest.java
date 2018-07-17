package tests;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup () {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @AfterClass
    public static void teardown () {
        driver.quit();
    }
}

