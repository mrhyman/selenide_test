package tests.driverPortal;

import models.GTCDriver;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.GTCDriverPortal.LoginPage;
import tests.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPage loginPage = PortalTest.getLoginPage();
    private static GTCDriver invalidDriver = PortalTest.getInvalidDriver();
    private static GTCDriver validDriver = PortalTest.getValidDriver();

    @BeforeClass
    public static void openLoginPage() {
        loginPage.openLoginPage();
    }

    @Test
    public void correctTitleIsShown() {
        loginPage.verifyTitle();
    }

    @Test
    public void correctHeadersAreShown() {
        loginPage.verifyPortalHeader();
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
    public void correctPlaceholdersAreShown() {
        loginPage.verifyEmailPlaceholder();
        loginPage.verifyPINPlaceholder();
    }

    @Test
    public void correctFooterIsShown() {
        loginPage.verifyFooter();
    }

    @Test
    public void correctLoginButtonTextIsShown() {
        loginPage.verifyLoginButtonText();
    }

    @Test
    public void invalidDriverLogin() {
        loginPage.setRememberMe();
        loginPage.login(invalidDriver);
        loginPage.verifyLogin(false);
    }

    @Test
    public void validDriverLogin() {
        loginPage.setRememberMe();
        PortalTest.setDriverPortalPage(loginPage.login(validDriver));
        loginPage.verifyLogin(true);
    }
}
