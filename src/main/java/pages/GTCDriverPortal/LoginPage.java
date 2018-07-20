package pages.GTCDriverPortal;//package pages.GTCDriverPortal;
//
////import helpers.Locators.Locators;
//import pages.PageObject;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class LoginPage extends PageObject {
//
////    By emailLocator = Locators.get("LoginPage.emailInput");
////    By pinLocator = Locators.get("LoginPage.pinInput");
//    By titleLocator = By.xpath("/html/head/title");
////    By rememberMeLocator = Locators.get("LoginPage.rememberMeCheckBox");
////    By loginButtonLocator = Locators.get("LoginPage.loginButton");
//
//    private final WebDriver driver;
//
////    public LoginPage(WebDriver driver) {
////        super();
////        this.driver = driver;
//
////        if (!Locators.get("LoginPage.title").equals(driver.getTitle())) {
////            throw new IllegalStateException("This is not the driver portal page");
////        }
////    }
//
////    public LoginPage enterDriverEmail(String email) {
////        driver.findElement(emailLocator).sendKeys(email);
////        return this;
////    }
//
////    public LoginPage enterDriverPin(String pin) {
////        driver.findElement(pinLocator).sendKeys(pin);
////        return this;
////    }
//
////    public LoginPage setRememberMe() {
////        driver.findElement(rememberMeLocator).click();
////        return this;
////    }
//
//    public String getTitle() {
//        return driver.findElement(titleLocator).getText();
//    }
//
////    public FirstJourneyPage loginDriver() {
////        driver.findElement(loginButtonLocator).click();
////        return new FirstJourneyPage(driver);
////    }
////
////    public LoginPage loginExpectingFailure() {
////        driver.findElement(loginButtonLocator).click();
////        return new LoginPage(driver);
////    }
////
////    public FirstJourneyPage loginAs(String email, String pin) {
////        enterDriverEmail(email);
////        enterDriverPin(pin);
////        setRememberMe();
////        return loginDriver();
////    }
//}
