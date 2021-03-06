package tests.driverPortal;

import helpers.JDBCconnector;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GTCDriverPortal.AvailabilityTab;
import tests.BaseTest;

public class AvailabilityTabTest extends BaseTest {

    private static AvailabilityTab availabilityTab;

    @BeforeClass
    public static void openPortalPage() {
        validDriver = JDBCconnector.getGTCDriver(JDBCconnector.validDriverQuery);
        JDBCconnector.getAddress(validDriver);

        availabilityTab = new AvailabilityTab(driver, wait, validDriver);
        availabilityTab.openDriverPortalPage(validDriver);
        availabilityTab.openTab("Availability");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[text()='Loading jobs...']/..")));
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        logger.info(validDriver.getMobileId() + " - " + validDriver.getFullName() + " driver is logged in");
        logger.info("*** Availability tab test suite started! ***");
    }

    @Test
    public void pageHasCorrectURL() {
        availabilityTab.verifyURL();
    }

    @Test
    public void tableHeaderIsShown() {
        availabilityTab.verifyDairyHeader();
    }

    @Test
    public void dairyNameIsShown() {
        availabilityTab.verifyDairyTableName();
    }

    @Test
    public void correctWeekDaysCount() {
        availabilityTab.verifyWeek();
    }

    @Test
    public void weekNotesFieldIsShown() {
        availabilityTab.verifyWeekNotes();
    }

    @Test
    public void buttonsAreShown() {
        availabilityTab.verifyButtons();
    }


}
