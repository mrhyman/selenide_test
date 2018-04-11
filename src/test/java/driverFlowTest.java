import com.codeborne.selenide.junit.ScreenShooter;
import helpers.Highlighter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class driverFlowTest {
    @BeforeClass
    public static void openDriverPortal() {
        timeout = 10000;
        baseUrl = "https://192.0.2.67/driver-portal";
        addListener(new Highlighter());
        open("/");
    }

    @AfterClass
    public static void logout() {
        closeWebDriver();
    }

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();
}
