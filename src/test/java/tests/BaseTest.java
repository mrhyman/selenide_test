package tests;

import io.qameta.allure.Attachment;
import models.GTCDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GTCDriverPortal.DriverPortalPage;
import pages.GTCDriverPortal.LoginPage;
import tests.driverPortal.LoginTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    protected static LoginPage loginPage;
    protected static DriverPortalPage driverPortalPage;
    protected static GTCDriver validDriver;
    protected static GTCDriver invalidDriver;

    public static Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeClass
    public static void setup() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 25);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public static DriverPortalPage getDriverPortalPage() {
        return driverPortalPage;
    }

    public void setDriverPortalPage(DriverPortalPage driverPortalPage) {
        this.driverPortalPage = driverPortalPage;
    }

    public static GTCDriver getValidDriver() {
        return validDriver;
    }

    public void setValidDriver(GTCDriver validDriver) {
        this.validDriver = validDriver;
    }

    public static GTCDriver getInvalidDriver() {
        return invalidDriver;
    }

    public void setInvalidDriver(GTCDriver invalidDriver) {
        this.invalidDriver = invalidDriver;
    }

    @AfterClass
    public static void teardown () {
        driver.quit();
    }

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.error(description);
            screenshot();
        }

        @Override
        protected void succeeded(Description description) {
            logger.info(description + " - success!");
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

