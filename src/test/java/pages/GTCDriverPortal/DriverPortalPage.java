package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

import java.util.ArrayList;
import java.util.List;

public class DriverPortalPage extends PageObject {

    public static String baseURL = "https://192.0.2.67/driver-portal/login";
    public GTCDriver gtcDriver;

    public DriverPortalPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public DriverPortalPage(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait);
        this.gtcDriver = gtcDriver;
    }

    public void openTab(String tabName) {
        click(By.xpath("//*[contains(text(), '"+tabName+"')]"));
    }

    public void verifyTitle() {
        Assert.assertEquals("greentomatocars - Driver Portal", driver.getTitle());
    }

    public void verifyLogo() {
        WebElement ImageFile = driver.findElement(By.tagName("img"));
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        Assert.assertEquals(ImagePresent, true);
    }

    public void verifyFooter() {
        WebElement leftFooter = driver.findElement(By.className("page-footer-left"));
        WebElement rightFooter = driver.findElement(By.className("page-footer-right"));
        Assert.assertTrue(leftFooter.getText().contains("If you have any questions please email us at") &&
                leftFooter.getText().contains("driverportal@greentomatocars.com") &&
                rightFooter.getText().contains("Copyright © 2018 greentomatocars"));
    }

    public void verifyLogoutButton() {
        Assert.assertEquals("Logout", driver.findElement(By.className("logout-link")).getText());
    }

    public void verifyDriverName() {
        Assert.assertEquals(gtcDriver.getFullName(), driver.findElement(By.className("user-info")).getText());
    }

    public void verifyTabs() {
        List<String> expectedTabs = new ArrayList<String>(6);
        expectedTabs.add("First Journey");
        expectedTabs.add("Payslips");
        expectedTabs.add("Not Paid Jobs");
        expectedTabs.add("Availability");
        expectedTabs.add("Work time report");
        expectedTabs.add("Profile");

        List<WebElement> tabs = driver.findElements(By.className("x-tab-wrap"));

        Assert.assertTrue(tabs.size() == expectedTabs.size());

        for(int i = 0; i < tabs.size();  i++) {
            Assert.assertEquals(expectedTabs.get(i), tabs.get(i).getText());
        }

    }
}
