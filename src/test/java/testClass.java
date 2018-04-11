import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class testClass {
    @BeforeClass
    public  static void openDriverPortal() {
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

    @Test
    public void driverPortalPageAccess() {
        open("https://192.0.2.67/driver-portal/login");
        $("#email").setValue("t@t.t");
        $("#password").setValue("6474");
        $(byName("_spring_security_remember_me")).click();
        $(byText("login")).click();
        $("#ext-gen1019").shouldBe(Condition.visible);
    }
}
