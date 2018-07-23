package tests;

import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    public static WebDriver driver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
    };

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public void screenshot() {
        if (driver == null) {
            return;
        }
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }
}

