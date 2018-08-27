package tests.driverPortal;

import helpers.JDBCconnector;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GTCDriverPortal.NotPaidJobsTab;
import tests.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void pageHasCorrectURL() {
        notPaidJobsTab.verifyURL();
    }

    @Test
    public void correctDateFromLabelIsShown() {
        notPaidJobsTab.verifyDateFromLabel();
    }

    @Test
    public void dateFromFieldIsShown() {
        notPaidJobsTab.verifyDateFromField();
    }

    @Test
    public void correctDateToLabelIsShown() {
        notPaidJobsTab.verifyDateToLabel();
    }

    @Test
    public void dateToFieldIsShown() {
        notPaidJobsTab.verifyDateToField();
    }

    @Test
    public void correctStatusLabelIsShown() {
        notPaidJobsTab.verifyStatusLabel();
    }

    @Test
    public void jobStatusFieldIsShown() {
        notPaidJobsTab.verifyStatusField();
    }

    @Test
    public void selectDate() {
        notPaidJobsTab.selectDate("dateFrom");
        notPaidJobsTab.verifyDate("dateFrom");

        notPaidJobsTab.selectDate("dateTo");
        notPaidJobsTab.verifyDate("dateTo");
        notPaidJobsTab.clickApplyButton();
    }

    @Test
    public void setApprovedJobStatus() {
        notPaidJobsTab.openStatusDropDown();
        notPaidJobsTab.selectJobStatus("Approved");
        notPaidJobsTab.verifyStatus("Approved");
    }

    @Test
    public void jobTableHeadersAreShown() {
        notPaidJobsTab.verifyTableHeaders();
    }

    @Test
    public void downloadButtonIsShown() {
        notPaidJobsTab.verifyDownloadButton();
    }
}
