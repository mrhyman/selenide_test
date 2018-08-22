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

        Thread.sleep(5000);

        logger.info(validDriver.getMobileId() + " - " + validDriver.getFullName() + " driver is logged in");
        logger.info("*** Payslips tab test suite started! ***");
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
    public void loadingJobsPopupSiShown() throws InterruptedException {
        payslipsTab.clickApplyButton();
        Thread.sleep(500);
        payslipsTab.verifyLoadingJobsPopUp();
    }

    @Test
    public void tableTabsAreShown() {
        payslipsTab.verifyJobsTab();
        payslipsTab.verifyCreditsTab();
        payslipsTab.verifyDeductionsTab();
        payslipsTab.verifyTableHeaders();
    }

    @AfterClass
    public static void logResults() {
        logger.info("*** Payslips tab test suite finished! ***" + "\n");
    }

}


