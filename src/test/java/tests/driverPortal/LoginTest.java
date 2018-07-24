package tests.driverPortal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tests.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

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
        loginPage.login(validDriver);
        loginPage.verifyLogin(true);
    }
}
