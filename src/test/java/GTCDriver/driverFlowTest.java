package GTCDriver;

import com.codeborne.selenide.junit.ScreenShooter;
import Helpers.Highlighter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static org.junit.Assert.assertEquals;

public class driverFlowTest {
    @BeforeClass
    public static void openDriverPortal() {
        timeout = 10000;
        baseUrl = "https://192.0.2.69/driver-portal";
        addListener(new Highlighter());
        open("/");
    }

    @AfterClass
    public static void logout() {
        closeWebDriver();
    }

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Test
    public void correctTitleIsShownTest() {
        assertEquals("greentomatocars - Driver Portal", title());
    }
}
