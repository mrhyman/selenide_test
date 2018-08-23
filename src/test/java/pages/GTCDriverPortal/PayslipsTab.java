package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PayslipsTab  extends DriverPortalPage{
    public PayslipsTab(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PayslipsTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void verifyURL() {
        Assert.assertEquals("https://192.0.2.67/driver-portal/#week-statements", driver.getCurrentUrl()); //hardcoded IP
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

    public void clickJobsTab() {
        click(By.id("tab-1067-btnIconEl"));
    }

    public void clickCreditsTab() {
        click(By.id("tab-1068-btnIconEl"));
    }

    public void clickDeductionsTab() {
        click(By.id("tab-1069-btnIconEl"));
    }

    public void verifyTableHeaders(String tabName) {
        WebElement table = null;
        int rowsCount = 0;

        switch (tabName) {
            case "Jobs":
                table = driver.findElement(By.id("headercontainer-1022-innerCt"));
                rowsCount = 17;
                break;
            case "Credits":
                table = driver.findElement(By.id("headercontainer-1042-innerCt"));
                rowsCount = 9;
                break;
            case "Deductions":
                table = driver.findElement(By.id("headercontainer-1054-innerCt"));
                rowsCount = 9;
                break;
        }

        List<WebElement> headers = table.findElements(By.className("x-column-header"));
        for (WebElement header : headers) {
            Assert.assertFalse(header.getText().equals(""));
            Assert.assertNotNull(header.getText());
        }

        Assert.assertEquals(rowsCount, headers.size()); //number of jobs table rows
    }

    public void verifyTableFooter() {
        WebElement footer = driver.findElement(By.className("x-docked-summary-bottom"));
        Assert.assertFalse(footer.getText().equals(""));
        Assert.assertNotNull(footer.getText());
    }

    public void verifyTotalFooter() {
        WebElement footer = driver.findElement(By.id("toolbar-1070"));
        Assert.assertFalse(footer.getText().equals(""));
        Assert.assertNotNull(footer.getText());
    }

    public void verifyDownloadButton() {
        WebElement button = driver.findElement(By.id("button-1088"));
        Assert.assertEquals("Download week statement", button.getText());
        Assert.assertNotNull(button.getText());
    }

    public void verifyDownload() throws InterruptedException {
        ArrayList<String> tabsHandles = new ArrayList<>(driver.getWindowHandles());
        String portalHandle = tabsHandles.get(0);
        driver.switchTo().window(tabsHandles.get(1));

        Assert.assertTrue(driver.getCurrentUrl().contains("https://192.0.2.67/driver-portal/api/pay/download/weekStatement?weekId="));

        Thread.sleep(1000);

        if (driver.getWindowHandles().size() > 1) {
            for(String handle : driver.getWindowHandles()) {
                if (!handle.equals(portalHandle)) {
                    driver.switchTo().window(handle);
                    driver.close();
                }
            }
        }
        driver.switchTo().window(portalHandle);
    }

    public void clickDownloadButton() {
        click(By.id("button-1088-btnIconEl"));
    }

    public void clickApplyButton() {
        click(By.id("button-1020-btnIconEl"));
    }
}
