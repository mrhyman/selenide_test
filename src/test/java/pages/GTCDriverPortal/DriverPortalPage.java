package pages.GTCDriverPortal;

import models.GTCDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

public class DriverPortalPage extends PageObject {

    public DriverPortalPage(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void openPayslipsTab() {
        click(By.id("tab-1212-btnInnerEl"));
    }

//    @Test
//    public void firstJourneyTabIsShownTest() {
//        $("#tab-1211-btnInnerEl")
//                .shouldBe(Condition.visible)
//                .shouldHave(text("First Journey"));
//    }
//
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
