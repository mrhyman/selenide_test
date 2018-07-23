package tests.driverPortal;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GTCDriverPortal.DriverPortalPage;
import tests.BaseTest;


public class FirstJourneyTabTest extends BaseTest {

    private static DriverPortalPage driverPortalPage = PortalTest.getDriverPortalPage();
    private static WebDriver driver = PortalTest.getDriver();

    @Test
    public void openPayslipsTab() {
        driverPortalPage.openTab("Payslips");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://192.0.2.67/driver-portal/#week-statements"));
    }

    @Test
    public void logoIsShown() {
        driverPortalPage.verifyLogo();
    }

    @Test
    public void correctFooterIsShown() {
        driverPortalPage.verifyFooter();
    }
}
