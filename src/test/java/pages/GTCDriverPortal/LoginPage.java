package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends DriverPortalPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openLoginPage() {
        driver.get(baseURL);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void enterEmail(String email) {
        deleteText(By.id("email"));
        writeText(By.id("email"), email);
    }

    public void enterPIN(String pin) {
        deleteText(By.id("password"));
        writeText(By.id("password"), pin);
    }

    public void setRememberMe() {
        WebElement checkBox = driver.findElement(By.className("lgn-checkbox-remember"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public FirstJourneyTab login(GTCDriver gtcDriver) {
        enterEmail(gtcDriver.getEmail());
        enterPIN(gtcDriver.getMobileId());
        click(By.tagName("button"));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return new FirstJourneyTab(driver, wait, gtcDriver);
    }

    public void verifyPortalHeader() {
        Assert.assertEquals("driver portal", readText(By.className("lgn-online-booking")));
    }

    public void verifyFormHeader() {
        Assert.assertEquals("please enter email and PIN", readText(By.className("lgn-header-label")));
    }

    public void verifyEmailLabel() {
        WebElement label = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div[2]/label"));
        Assert.assertEquals("email:", label.getText());
    }

    public void verifyEmailPlaceholder() {
        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.getAttribute("placeholder").equals("email"));
    }

    public void verifyPINPlaceholder() {
        WebElement email = driver.findElement(By.id("password"));
        Assert.assertTrue(email.getAttribute("placeholder").equals("PIN"));
    }

    public void verifyPINLabel() {
        WebElement label = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div[3]/label"));
        Assert.assertEquals("PIN:", label.getText());
    }

    public void verifyRememberMeLabel() {
        WebElement label = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div[4]/label"));
        Assert.assertEquals("remember me:", label.getText());
    }

    @Override
    public void verifyFooter() {
        WebElement footer = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));
        Assert.assertTrue(footer.getText().contains("*if you are having trouble logging in then please contact ") &&
                footer.getText().contains("driverportal@greentomatocars.com"));
    }

    public void verifyLoginButtonText() {
        WebElement button = driver.findElement(By.className("button-main"));
        Assert.assertTrue(button.getText().equals("login"));
    }

    public void verifyLogin(Boolean valid) {
        if (valid) {
            Assert.assertTrue(driver.getCurrentUrl().equals("https://192.0.2.67/driver-portal/"));
        } else {
            WebElement message = driver.findElement(By.className("errorMessage"));
            Assert.assertEquals("Invalid email or password", message.getText());
        }

    }
}
