package Pages.GTCDriverPortal;

import Helpers.Locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By emailLocator = Locators.get("LoginPage.emailInput");
    By pinLocator = Locators.get("LoginPage.pinInput");
    By rememberMeLocator = Locators.get("LoginPage.rememberMeCheckBox");
    By loginButtonLocator = Locators.get("LoginPage.loginButton");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        if (!Locators.get("LoginPage.title").equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the driver portal page");
        }
    }

    public LoginPage enterDriverEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public LoginPage enterDriverPin(String pin) {
        driver.findElement(pinLocator).sendKeys(pin);
        return this;
    }

    public LoginPage setRememberMe() {
        driver.findElement(rememberMeLocator).click();
        return this;
    }

    public FirstJourneyPage loginDriver() {
        driver.findElement(loginButtonLocator).click();
        return new FirstJourneyPage(driver);
    }

    public LoginPage loginExpectingFailure() {
        driver.findElement(loginButtonLocator).click();
        return new LoginPage(driver);
    }

    public FirstJourneyPage loginAs(String email, String pin) {
        enterDriverEmail(email);
        enterDriverPin(pin);
        setRememberMe();
        return loginDriver();
    }
}
