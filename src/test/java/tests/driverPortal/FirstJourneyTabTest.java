package tests.driverPortal;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.GTCDriverPortal.FirstJourneyTab;
import tests.BaseTest;

public class FirstJourneyTabTest extends BaseTest {

    private static FirstJourneyTab firstJourneyTab;

    @BeforeClass
    public static void openPortalPage() {
        firstJourneyTab = loginPage.login(validDriver);
    }

//    @Test
//    public void openPayslipsTab() {
//        driverPortalPage.openTab("Payslips");
//        Assert.assertTrue(driver.getCurrentUrl().equals("https://192.0.2.67/driver-portal/#week-statements"));
//    }

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
    public void correctDriverShiftIsShown() {
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

    //    @Test
//    public void firstJourneyTabIsShownTest() {
//        $("#tab-1211-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("First Journey"));
//    }

//    @Test
//    public void firstPayslipsTabIsShownTest() {
//        $("#tab-1212-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("Payslips"));
//    }
//
//    @Test
//    public void firstNotPaidJobsTabIsShownTest() {
//        $("#tab-1213-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("Not Paid Jobs"));
//    }
//
//    @Test
//    public void firstAvailabilityTabIsShownTest() {
//        $("#tab-1214-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("Availability"));
//    }
//
//    @Test
//    public void firstWorkTimeReportTabIsShownTest() {
//        $("#tab-1215-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("Work time report"));
//    }
//
//    @Test
//    public void profileTabIsShownTest() {
//        $("#tab-1216-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("Profile"));
//    }
//
//    @Test
//    public void driverAddressIsShownTest() {
//        $("#textfield-1011-inputEl")
//                .shouldBe(Condition.visible)
//                .shouldNotBe(Condition.empty);
//    }
//
//    @Test
//    public void driverNextShiftIsShownTest() {
//        $("#textfield-1012-inputEl")
//                .shouldBe(Condition.visible)
//                .shouldNotBe(Condition.empty);
//    }
//
//    @Test
//    public void mapIsShownTest() {
//        $("#mapFrame").shouldBe(Condition.visible);
//    }
//
//    @Test
//    public void jobsTableIsShown() {
//        $("#panel-1013").shouldBe(visible);
//    }
//
//    @Test
//    public void selectFirstJobButtonIsShownTest() {
//        if (getElements(By.className("x-grid-row")).size() > 0) {
//            $("#button-1014").shouldNotHave(cssClass("x-btn-disabled"));
//        } else {
//            $("#button-1014").shouldHave(cssClass("x-btn-disabled"));
//        }
//        $("#button-1014").shouldHave(text("Select"));
//    }
}
