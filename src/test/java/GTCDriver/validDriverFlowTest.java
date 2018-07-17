//package GTCDriver;
//
//import com.codeborne.selenide.Condition;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import Backlog.GTCdrivers.validDriver;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.*;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.getElements;
//
//public class validDriverFlowTest extends driverFlowTest {
//
//    @BeforeClass
//    public static void login() {
//        $("#loadmask-1218-msgEl").waitUntil(Condition.disappears, 10000);
//        $("#email").setValue(validDriver.EMAIL);
//        $("#password").setValue(validDriver.PIN);
//        $(byName("_spring_security_remember_me")).click();
//        $(byText("login")).click();
//    }
//
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
//}
