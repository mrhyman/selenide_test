package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static LoginPage loginPage;

    @BeforeClass
    public static void LoginPageSetup() {
        loginPage = new LoginPage(driver, wait);
        loginPage.openDriverPortal();
    }

    @Test
    public void correctTitleIsShown() {
        loginPage.verifyTitle();
    }

    @Test
    public void correctHeadersAreShown() {
        loginPage.verifyProtalHeader();
        loginPage.verifyFormHeader();
    }

    @Test
    public void logoIsShown() {
        loginPage.verifyLogo();
    }

    @Test
    public void correctLabelsAreShown() {
        loginPage.verifyEmailLabel();
        loginPage.verifyPINLabel();
        loginPage.verifyRememberMeLabel();
    }

    @Test
    public void correctFooterIsShown() {
        loginPage.verifyFooter();
    }

    @Test
    public void correntLoginButtonTextIsShown() {
        loginPage.verifyLoginButtonText();
    }

    @Test
    public void driverLogin() {
        loginPage.setRememberMe();
        loginPage.login("t@t.t", "6474");
        loginPage.verifyLogin();
    }
}
