package tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.LoginPage;

@RunWith(JUnitParamsRunner.class)
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
    @Parameters({
            "totalywrong@email.com,111,false",
            "t@t.t,6474,true"
    })
    public void driverLogin(String email, String pin, Boolean valid) {
        loginPage.login(email, pin);
        loginPage.verifyLogin(valid);
    }
}
