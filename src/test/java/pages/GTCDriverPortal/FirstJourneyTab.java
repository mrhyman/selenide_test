package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstJourneyTab extends DriverPortalPage {
    public FirstJourneyTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void verifyMap() {
        WebElement map = driver.findElement(By.xpath("//*[@id=\"map\"]"));
        Assert.assertTrue(map != null);
    }

    public void verifyAddress() {
        WebElement address = driver.findElement(By.xpath("//*[@id=\"textfield-1011-inputEl\"]"));
        String expectedAddress = address.getAttribute("value");
        Assert.assertEquals(expectedAddress, this.gtcDriver.getAddress());
    }

    public void verifyAddressLabel() {
        WebElement addressLabel = driver.findElement(By.xpath("//*[@id=\"textfield-1011-labelEl\"]"));
        Assert.assertEquals("Driver address:", addressLabel.getText());
    }

    public void verifyCurrentShift() {
        WebElement shift = driver.findElement(By.xpath("//*[@id=\"textfield-1012-inputEl\"]"));
        Assert.assertEquals(shift.getText(), this.gtcDriver.getEmail());
    }

    public void verifyCurrentShiftLabel() {
        WebElement shiftLabel = driver.findElement(By.xpath("//*[@id=\"textfield-1012-labelEl\"]"));
        Assert.assertEquals("Current shift:", shiftLabel.getText());
    }

    public void verifyJobsTable() {
        WebElement jobTable = driver.findElement(By.xpath("//*[@id=\"panel-1013-body\"]"));
        Assert.assertTrue(jobTable != null);
    }

    public void verifyJobsTableTitle() {
        WebElement tableTitle = driver.findElement(By.xpath("//*[@id=\"fieldset-1227-legendTitle\"]"));
        Assert.assertEquals("Available jobs", tableTitle.getText());
    }

}
