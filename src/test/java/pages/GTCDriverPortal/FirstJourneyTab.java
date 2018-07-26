package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
        Assert.assertTrue(shift != null);
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

    public void verifyJobsTableHeaders() {
        List<String> expectedHeaders = new ArrayList<String>(4);
        expectedHeaders.add("Reference");
        expectedHeaders.add("PU postcode");
        expectedHeaders.add("PU date/time");
        expectedHeaders.add("Distance, mi");

        List<WebElement> headers = driver.findElements(By.className("x-column-header-text"));

        Assert.assertTrue(headers.size() == expectedHeaders.size());

        for(int i = 0; i < headers.size();  i++) {
            Assert.assertEquals(expectedHeaders.get(i), headers.get(i).getText());
        }
    }

    public boolean verifySelectButton() {
        List<WebElement> jobs = driver.findElements(By.className("x-grid-row"));
        WebElement selectButton = driver.findElement(By.id("button-1014"));

        if (jobs != null && jobs.size() > 0) {
            Assert.assertTrue(!selectButton.getAttribute("class").contains("x-btn-disabled"));
            return true;
        } else {
            Assert.assertTrue(selectButton.getAttribute("class").contains("x-btn-disabled"));
            return false;
        }
    }

    public void selectJob() {
        List<WebElement> jobs = driver.findElements(By.className("x-grid-row"));
        WebElement job = jobs.get((int) Math.random()*jobs.size());
        if (jobs != null && jobs.size() > 0) {
            click(By.id("gridview-1226-record-" + job.getAttribute("data-recordid")));
            click(By.id("button-1014-btnIconEl"));
            click(By.id("button-1006-btnIconEl"));
        }
    }

    public void verifySelectedJobTableHeader() {
        WebElement tableHeader = driver.findElement(By.id("fieldset-1235-legendTitle"));
        Assert.assertTrue(tableHeader != null);
    }

}
