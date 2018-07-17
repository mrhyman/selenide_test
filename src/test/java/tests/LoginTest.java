package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static LoginPage loginPage;

    @BeforeClass
    public static void LoginPageSetup() {
        loginPage = new LoginPage(driver, wait);
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
    public void driverWithWrongCredentialsLogin() {
        loginPage.login("totalywrong@email.com", "111");
        loginPage.verifyErrorMessage();
    }

    @Test
    public void driverLogin() {
        loginPage.setRememberMe();
        loginPage.login("t@t.1t", "6474");
        loginPage.verifyLogin();
    }
}
