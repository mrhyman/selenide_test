package tests.driverPortal;

import helpers.JDBCconnector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.GTCDriverPortal.PayslipsTab;
import tests.BaseTest;



public class PayslipsTabTest extends BaseTest {

    private static PayslipsTab payslipsTab;

    @BeforeClass
    public static void openPayslipsTab() throws InterruptedException {
        validDriver = JDBCconnector.getGTCDriver(JDBCconnector.validDriverQuery);
        JDBCconnector.getAddress(validDriver);

        payslipsTab = new PayslipsTab(driver, wait, validDriver);
        payslipsTab.openDriverPortalPage(validDriver);
        payslipsTab.openTab("Payslips");

        Thread.sleep(15000); //fix waiting till loading popups disappear

        logger.info(validDriver.getMobileId() + " - " + validDriver.getFullName() + " driver is logged in");
        logger.info("*** Payslips tab test suite started! ***");
    }

    @Test
    public void payslipPageHasCorrectAddress() {
        payslipsTab.verifyURL();
    }

    @Test
    public void monthLabelIsShown() {
        payslipsTab.verifyMonthLabel();
    }

    @Test
    public void weekLabelIsShown() {
        payslipsTab.verifyWeekLabel();
    }

    @Test
    public void monthDropdownIsShown() {
        payslipsTab.verifyMonthDropdown();
    }

    @Test
    public void weekDropdownIsShown() {
        payslipsTab.verifyWeekDropdown();
    }

    @Test
    public void applyButtonIsShown() {
        payslipsTab.verifyApplyButton();
    }

    @Test
    public void loadingJobsPopupIsShown() throws InterruptedException {
        payslipsTab.clickApplyButton();
        Thread.sleep(500);
        payslipsTab.verifyLoadingJobsPopUp();
    }

    @Test
    public void tableTabsAreShown() {
        payslipsTab.verifyJobsTab();
        payslipsTab.verifyCreditsTab();
        payslipsTab.verifyDeductionsTab();
    }

    @Test
    public void jobsTableHeadersAreShown() {
        payslipsTab.clickJobsTab();
        payslipsTab.verifyTableHeaders("Jobs");
    }

    @Test
    public void creditsTableHeadersAreShown() {
        payslipsTab.clickCreditsTab();
        payslipsTab.verifyTableHeaders("Credits");
    }

    @Test
    public void deductionsTableHeadersAreShown() {
        payslipsTab.clickDeductionsTab();
        payslipsTab.verifyTableHeaders("Deductions");
    }

    @Test
    public void tableFooterIsShown() {
        payslipsTab.verifyTableFooter();
    }

    @Test
    public void totalFooterIsShown() {
        payslipsTab.verifyTotalFooter();
    }

    @Test
    public void downloadButtonIsShown() {
        payslipsTab.verifyDownloadButton();
    }

    @Test
    public void downloadStarted() throws InterruptedException {
        payslipsTab.clickDownloadButton();
        payslipsTab.verifyDownload();
    }

    @AfterClass
    public static void logResults() {
        logger.info("*** Payslips tab test suite finished! ***" + "\n");
    }

}


