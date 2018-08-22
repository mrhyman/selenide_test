package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PayslipsTab  extends DriverPortalPage{
    public PayslipsTab(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PayslipsTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void verifyMonthLabel() {
        WebElement label = driver.findElement(By.id("combobox-1018-labelEl"));
        Assert.assertEquals(label.getText(), "Month:");
    }

    public void verifyWeekLabel() {
        WebElement label = driver.findElement(By.id("combobox-1019-labelEl"));
        Assert.assertEquals(label.getText(), "Week:");
    }

    public void verifyMonthDropdown() {
        WebElement dropdown = driver.findElement(By.id("combobox-1018-inputEl"));
        Assert.assertNotEquals(dropdown.getAttribute("value"), "");
        Assert.assertNotEquals(dropdown, null);
    }

    public void verifyWeekDropdown() {
        WebElement dropdown = driver.findElement(By.id("combobox-1019-inputEl"));
        Assert.assertNotEquals(dropdown.getAttribute("value"), "");
        Assert.assertNotEquals(dropdown, null);
    }

    public void verifyApplyButton() {
        WebElement applyButton = driver.findElement(By.id("button-1020-btnIconEl"));
        Assert.assertNotEquals(applyButton.getAttribute("value"), "Apply");
        Assert.assertNotEquals(applyButton, null);
    }

    public void verifyLoadingJobsPopUp() {
        List<WebElement> elements = driver.findElements(By.className("x-mask-msg-text"));
        WebElement popUp = elements.get(elements.size() - 1);
        Assert.assertNotEquals(popUp.getAttribute("value"), "Loading jobs...");
        Assert.assertNotEquals(popUp, null);
    }

    public void clickApplyButton() {
        click(By.id("button-1020-btnIconEl"));
    }

    public void verifyJobsTab() {
        WebElement tab = driver.findElement(By.id("tab-1067-btnInnerEl"));
        Assert.assertEquals("Jobs", tab.getText());
    }

    public void verifyCreditsTab() {
        WebElement tab = driver.findElement(By.id("tab-1068-btnInnerEl"));
        Assert.assertEquals("Credits", tab.getText());
    }

    public void verifyDeductionsTab() {
        WebElement tab = driver.findElement(By.id("tab-1069-btnInnerEl"));
        Assert.assertEquals("Deductions", tab.getText());
    }

    public void verifyTableHeaders() {
        List<WebElement> headers = driver.findElements(By.className("x-column-header-text"));
        for (WebElement header : headers) {
            System.out.println(header.getText() + " " + Character.toString((char) 0x00A3));
        }
    }
}
