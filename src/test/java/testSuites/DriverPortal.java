package testSuites;

import com.codeborne.selenide.junit.ScreenShooter;
import helpers.Highlighter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCases.driverPortals.GTC.FirstJourneyTabTest;
import testCases.driverPortals.GTC.InvalidDriverTest;
import testCases.driverPortals.GTC.ValidDriverTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InvalidDriverTest.class,
        ValidDriverTest.class,
        FirstJourneyTabTest.class
})
public class DriverPortal {

    @BeforeClass
    public static void openDriverPortal() {
        timeout = 1000;
        baseUrl = "https://192.0.2.69/driver-portal";
        addListener(new Highlighter());
        open("/");
    }

    @AfterClass
    public static void closeDriverPortal() {
        closeWebDriver();
    }

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();
}
