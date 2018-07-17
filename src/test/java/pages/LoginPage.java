package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {

    String baseURL = "https://192.0.2.67/driver-portal/login";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openDriverPortal() {
        driver.get(baseURL);
    }

    public void enterEmail(String email) {
        writeText(By.id("email"), email);
    }

    public void enterPIN(String pin) {
        writeText(By.id("password"), pin);
    }

    public void login(String email, String pin) {
        enterEmail(email);
        enterPIN(pin);
        click(By.xpath("/html/body/div[2]/div[1]/form/div[5]/div/span[3]/em[2]/button"));
    }

    public void verifyLogin() {
        Assert.assertEquals(readText(By.className("user-info")), "VladimirKrasnoSolnishko Ivan");
    }

    public void verifyTitle() {
        Assert.assertEquals(readText(By.xpath("/html/head/title")), "greentomatocars - Driver Portal");
    }


}
