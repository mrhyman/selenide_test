package tests;

import helpers.JDBCconnector;
import io.qameta.allure.Attachment;
import models.GTCDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GTCDriverPortal.DriverPortalPage;
import pages.GTCDriverPortal.LoginPage;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    protected static LoginPage loginPage;
    protected static DriverPortalPage driverPortalPage;
    protected static GTCDriver validDriver;
    protected static GTCDriver invalidDriver;

    @BeforeClass
    public static void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();

        validDriver = JDBCconnector.returnGTCDriver(JDBCconnector.validDriverQuery);
        invalidDriver = JDBCconnector.returnGTCDriver(JDBCconnector.InvalidDriverQuery);

        loginPage = new LoginPage(driver, wait);
        loginPage.openLoginPage();
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

