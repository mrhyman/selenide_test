package tests.driverPortal;

import helpers.JDBCconnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runners.MethodSorters;
import org.slf4j.event.LoggingEvent;
import pages.GTCDriverPortal.LoginPage;
import tests.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    @BeforeClass
    public static void getDrivers() {
        validDriver = JDBCconnector.getGTCDriver(JDBCconnector.validDriverQuery);
        invalidDriver = JDBCconnector.getGTCDriver(JDBCconnector.invalidDriverQuery);
        logger.info("*** Login test suite started! ***");

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

    @AfterClass
    public static void logResults() {
        logger.info("*** Login test suite finished! ***" + "\n");
    }
}
