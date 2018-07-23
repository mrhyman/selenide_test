package tests;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GTCDriverPortal.DriverPortalPage;


public class FirstJourneyTabTest extends BaseTest{

    private static DriverPortalPage driverPortalPage = PortalTest.getDriverPortalPage();
    private static WebDriver driver = PortalTest.getDriver();

    @Test
    public void openPayslipsTab() {
        driverPortalPage.openPayslipsTab();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://192.0.2.67/driver-portal/#week-statements"));
    }
}
