package pages.driverPortal.gtc;

import com.codeborne.selenide.Condition;
import pages.driverPortal.DriverPortalPage;
import testData.drivers.Driver;
import testData.drivers.InvalidDriver;
import testData.drivers.ValidDriver;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GTCDriverLoginPage implements DriverPortalPage {

    private static void login(Driver driver) {
        $("#email").setValue(driver.EMAIL);
        $("#password").setValue(driver.PIN);
        $(byName("_spring_security_remember_me")).click();
        $(byText("login")).click();
    }

    public static GTCDriverLoginPage validLogin(ValidDriver driver) {
        login(driver);
        $("#loadmask-1218-msgEl").waitUntil(Condition.disappears, 10000);
        return page(GTCDriverLoginPage.class);
    }

    public static GTCDriverLoginPage invalidLogin(InvalidDriver driver) {
        login(driver);
        return page(GTCDriverLoginPage.class);
    }
}
