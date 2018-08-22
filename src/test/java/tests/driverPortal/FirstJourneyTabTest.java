package tests.driverPortal;

import helpers.JDBCconnector;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.GTCDriverPortal.FirstJourneyTab;
import tests.BaseTest;

public class FirstJourneyTabTest extends BaseTest {

    private static FirstJourneyTab firstJourneyTab;

    @BeforeClass
    public static void openPortalPage() {
        validDriver = JDBCconnector.getGTCDriver(JDBCconnector.validDriverQuery);
        JDBCconnector.getAddress(validDriver);

        firstJourneyTab = new FirstJourneyTab(driver, wait, validDriver);
        firstJourneyTab.openDriverPortalPage(validDriver);

        logger.info(validDriver.getMobileId() + " - " + validDriver.getFullName() + " driver is logged in");
        logger.info("*** First Journey tab test suite started! ***");
    }

    @Test
    public void logoIsShown() {
        firstJourneyTab.verifyLogo();
    }

    @Test
    public void correctFooterIsShown() {
        firstJourneyTab.verifyFooter();
    }

    @Test
    public void logoutButtonIsShown() {
        firstJourneyTab.verifyLogoutButton();
    }

    @Test
    public void correctDriverNameIsShown() {
        firstJourneyTab.verifyDriverName();
    }

    @Test
    public void mapIsShown() {
        firstJourneyTab.verifyMap();
    }

    @Test
    public void correctPageTitleIsShown() {
        firstJourneyTab.verifyTitle();
    }

    @Test
    public void correctDriverAddressIsShown() {
        firstJourneyTab.verifyAddress();
    }

    @Test
    public void driverShiftFieldIsNotEmpty() {
        firstJourneyTab.verifyCurrentShift();
    }

    @Test
    public void correctDriverAddressLabelIsShown() {
        firstJourneyTab.verifyAddressLabel();
    }

    @Test
    public void correctDriverShiftLabelIsShown() {
        firstJourneyTab.verifyCurrentShiftLabel();
    }

    @Test
    public void correctTabsAreShown() {
        firstJourneyTab.verifyTabs();
    }

    @Test
    public void jobsTableIsShown() {
        firstJourneyTab.verifyJobsTable();
    }

    @Test
    public void correctJobsTableTitleIsShown() {
        firstJourneyTab.verifyJobsTableTitle();
    }

    @Test
    public void correctJobsTableHeadersAreShown() {
        firstJourneyTab.verifyJobsTableHeaders();
    }

    @Test
    public void selectButtonIsShown() {
        firstJourneyTab.verifySelectButton();
    }
}
