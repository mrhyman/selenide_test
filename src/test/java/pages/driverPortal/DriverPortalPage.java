package pages.driverPortal;

import pages.driverPortal.gtc.GTCDriverLoginPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public interface DriverPortalPage {

    default GTCDriverLoginPage logout() {
        $(byText("Logout")).click();
        return page(GTCDriverLoginPage.class);
    }
}
