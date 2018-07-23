package tests.driverPortal;

import helpers.JDBCconnector;
import models.GTCDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GTCDriverPortal.DriverPortalPage;
import pages.GTCDriverPortal.LoginPage;
import tests.BaseTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, FirstJourneyTabTest.class})
public class PortalTest extends BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private static GTCDriver gtcDriver;
    private static LoginPage loginPage;
    private static DriverPortalPage driverPortalPage;

    private static GTCDriver validDriver;
    private static GTCDriver invalidDriver;

    @BeforeClass
    public static void setup() {

        if (driver == null) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,15);
            driver.manage().window().maximize();
        }

        loginPage = new LoginPage(driver, wait);
        loginPage.openLoginPage();

        validDriver = JDBCconnector.returnGTCDriver(JDBCconnector.validDriverQuery);
        invalidDriver = JDBCconnector.returnGTCDriver(JDBCconnector.InvalidDriverQuery);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        PortalTest.driver = driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        PortalTest.wait = wait;
    }

    public static GTCDriver getGtcDriver() {
        return gtcDriver;
    }

    public static void setGtcDriver(GTCDriver gtcDriver) {
        PortalTest.gtcDriver = gtcDriver;
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static void setLoginPage(LoginPage loginPage) {
        PortalTest.loginPage = loginPage;
    }

    public static DriverPortalPage getDriverPortalPage() {
        return driverPortalPage;
    }

    public static void setDriverPortalPage(DriverPortalPage driverPortalPage) {
        PortalTest.driverPortalPage = driverPortalPage;
    }

    public static GTCDriver getValidDriver() {
        return validDriver;
    }

    public static void setValidDriver(GTCDriver validDriver) {
        PortalTest.validDriver = validDriver;
    }

    public static GTCDriver getInvalidDriver() {
        return invalidDriver;
    }

    public static void setInvalidDriver(GTCDriver invalidDriver) {
        PortalTest.invalidDriver = invalidDriver;
    }



    @AfterClass
    public static void teardown () {
        driver.quit();
    }
}
