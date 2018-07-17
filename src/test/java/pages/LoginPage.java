package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {

    String baseURL = "https://192.0.2.67/driver-portal/login";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openLoginPage() {
        driver.get(baseURL);
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

    public void login(String email, String pin) {
        enterEmail(email);
        enterPIN(pin);
        click(By.tagName("button"));
    }

    public void verifyLogin() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://192.0.2.67/driver-portal/"));
    }

    public void verifyTitle() {
        Assert.assertEquals("greentomatocars - Driver Portal", driver.getTitle());
    }

    public void verifyPortalHeader() {
        Assert.assertEquals("driver portal", readText(By.className("lgn-online-booking")));
    }

    public void verifyFormHeader() {
        Assert.assertEquals("please enter email and PIN", readText(By.className("lgn-header-label")));
    }

    public void verifyLogo() {
        WebElement ImageFile = driver.findElement(By.tagName("img"));
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        Assert.assertEquals(ImagePresent, true);
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

    public void verifyFooter() {
        WebElement footer = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));
        Assert.assertTrue(footer.getText().contains("*if you are having trouble logging in then please contact ") &&
                footer.getText().contains("driverportal@greentomatocars.com"));
    }

    public void verifyLoginButtonText() {
        WebElement button = driver.findElement(By.className("button-main"));
        Assert.assertTrue(button.getText().equals("login"));
    }

    public void verifyErrorMessage() {
        WebElement message = driver.findElement(By.className("errorMessage"));
        Assert.assertEquals("Invalid email or password", message.getText());
    }
}
