package testCases.driverPortals.GTC;

import com.codeborne.selenide.Condition;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Suite;
import pages.driverPortal.gtc.GTCDriverLoginPage;
import testData.drivers.ValidDriver;

import java.time.Year;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Suite.SuiteClasses({
        FirstJourneyTabTest.class
})
public class ValidDriverTest extends GTCDriverPortal {

    @BeforeClass
    public static void validDriverLogin() {
        GTCDriverLoginPage.validLogin(new ValidDriver());

    }

    @Test
    public void firstJourneyTabIsShownTest() {
        $("#tab-1211-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("First Journey"));
    }

    @Test
    public void payslipsTabIsShownTest() {
        $("#tab-1212-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("Payslips"));
    }

    @Test
    public void notPaidJobsTabIsShownTest() {
        $("#tab-1213-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("Not Paid Jobs"));
    }

    @Test
    public void availabilityTabIsShownTest() {
        $("#tab-1214-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("Availability"));
    }

    @Test
    public void workTimeReportTabIsShownTest() {
        $("#tab-1215-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("Work time report"));
    }

    @Test
    public void profileTabIsShownTest() {
        $("#tab-1216-btnInnerEl")
                .shouldBe(Condition.visible)
                .shouldHave(text("Profile"));
    }

    @Test
    public void driverGreetingIsShownTest() {
        $(byClassName("logout")).shouldHave(text("Hello, "));
        $(byText(new ValidDriver().NAME)).shouldBe(visible);
    }

    @Test
    public void logoutLinkIsShownTest(){
        $(byText("Logout")).shouldBe(visible);
    }

    @Test
    public void logoIsShownTest(){
        $(byXpath("//*[@id=\"ext-gen1019\"]/div[1]/img")).isImage();
    }

    @Test
    public void contactUsFooterIsShownTest(){
        $(byClassName("page-footer-left"))
                .shouldBe(visible)
                .shouldHave(text("If you have any questions please email us at "));
    }

    @Test
    public void copyrightFooterIsShownTest(){
        int year = Year.now().getValue();
        $(byClassName("page-footer-right"))
                .shouldBe(visible)
                .shouldHave(text("Copyright © " + year + " greentomatocars"));
    }

}
