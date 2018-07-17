package tests;

import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void correctTitleIsShown() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.openDriverPortal();
        loginPage.verifyTitle();
    }

    @Test
    public void driverLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.openDriverPortal();
        loginPage.login("t@t.t", "6474");
        loginPage.verifyLogin();
    }
}
