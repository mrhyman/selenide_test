package tests.driverPortal;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import tests.BaseTest;

public class FirstJourneyTabTest extends BaseTest {

    @BeforeClass
    public static void openPortalPage() {
        driverPortalPage = loginPage.login(validDriver);
    }

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

    @Test
    public void logoutButtonIsShown() {
        driverPortalPage.verifyLogoutButton();
    }

    @Test
    public void correctDriverNameIsShown() {
        driverPortalPage.verifyDriverName();
    }
}
