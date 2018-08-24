package tests.driverPortal;

import helpers.JDBCconnector;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GTCDriverPortal.NotPaidJobsTab;
import tests.BaseTest;

public class NotPaidJobsTest extends BaseTest {

    private static NotPaidJobsTab notPaidJobsTab;

    @BeforeClass
    public static void openPayslipsTab() {
        validDriver = JDBCconnector.getGTCDriver(JDBCconnector.validDriverQuery);
        JDBCconnector.getAddress(validDriver);

        notPaidJobsTab = new NotPaidJobsTab(driver, wait, validDriver);
        notPaidJobsTab.openDriverPortalPage(validDriver);
        notPaidJobsTab.openTab("Not Paid Jobs");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[text()='Loading jobs...']/..")));

        logger.info(validDriver.getMobileId() + " - " + validDriver.getFullName() + " driver is logged in");
        logger.info("*** Not Paid Jobs tab test suite started! ***");
    }

    @Test
    public void selectDate() {
        notPaidJobsTab.selectDate("dateFrom");
        notPaidJobsTab.selectDate("dateTo");
    }
}
