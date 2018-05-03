import com.codeborne.selenide.junit.ScreenShooter;
import helpers.Highlighter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        invalidDriverFlowTest.class,
        firstJourneyTabTest.class
})
public class driverFlowTestSuite {

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
