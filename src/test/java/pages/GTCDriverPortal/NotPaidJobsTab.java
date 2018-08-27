package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NotPaidJobsTab extends DriverPortalPage {

    public NotPaidJobsTab(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NotPaidJobsTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void verifyURL() {
        Assert.assertEquals("https://192.0.2.67/driver-portal/#not-paid-jobs", driver.getCurrentUrl()); //hardcoded IP
    }

    public void verifyDateFromLabel() {
        WebElement label = driver.findElement(By.id("datefield-1111-labelEl"));
        Assert.assertEquals("Date from:", label.getText());
    }

    public void verifyDateFromField() {
        WebElement dateField = driver.findElement(By.id("datefield-1111-inputEl"));
        Assert.assertEquals("dd/mm/yyyy", dateField.getAttribute("placeholder"));
        Assert.assertEquals("", dateField.getAttribute("value"));
    }

    public void verifyDateToLabel() {
        WebElement label = driver.findElement(By.id("datefield-1112-labelEl"));
        Assert.assertEquals("Date to:", label.getText());
    }

    public void verifyDateToField() {
        WebElement dateField = driver.findElement(By.id("datefield-1111-inputEl"));
        Assert.assertEquals("dd/mm/yyyy", dateField.getAttribute("placeholder"));
        Assert.assertEquals("", dateField.getAttribute("value"));
    }

    public void verifyStatusLabel() {
        WebElement label = driver.findElement(By.id("combobox-1110-labelEl"));
        Assert.assertEquals("Status:", label.getText());
    }

    public void verifyStatusField() {
        WebElement dateField = driver.findElement(By.id("combobox-1110-inputEl"));
        Assert.assertEquals("All", dateField.getAttribute("value"));
    }

    public void clickApplyButton() {
        click(By.id("button-1113"));
    }

    public void openStatusDropDown() {
        click(By.id("combobox-1110-bodyEl"));
    }

    public void selectJobStatus(String status) {
        List<WebElement> listItems = driver.findElements(By.className("x-boundlist-item"));

        switch (status) {
            case "Approved" :
                listItems.get(1).click();
                break;
            case "All" :
                listItems.get(0).click();
                break;
        }
    }

    public void closeStatusDropDown() {
        WebElement dropDown = driver.findElement(By.id("combobox-1110-bodyEl"));
        dropDown.sendKeys(Keys.TAB);
    }

    public void selectDate(String dateType) {
        int today = 1;
        int date = 1;
        WebElement datePicker = null;
        List<WebElement> activeDates = null;

        switch (dateType) {
            case "dateFrom":
                datePicker = driver.findElements(By.className("x-form-trigger")).get(0);
                datePicker.click();
                today = Integer.parseInt(driver.findElements(
                        By.className("x-datepicker-today"))
                        .get(0)
                        .getText()
                        .replaceAll("[^0-9]", ""));
                date = today - 7 > 0 ? today - 7 : 1; //hardcoded week ago date
                activeDates = driver
                        .findElements(By.className("x-datepicker-inner"))
                        .get(0)
                        .findElements(By.className("x-datepicker-active"));
                break;
            case "dateTo":
                datePicker = driver.findElements(By.className("x-form-trigger")).get(1);
                datePicker.click();
                today = Integer.parseInt(driver.findElements(
                        By.className("x-datepicker-today"))
                        .get(1)
                        .getText()
                        .replaceAll("[^0-9]", ""));
                date = today - 3 > 0 ? today - 3 : 1; //hardcoded 3 days ago date
                activeDates = driver
                        .findElements(By.className("x-datepicker-inner"))
                        .get(1)
                        .findElements(By.className("x-datepicker-active"));
                break;
        }

        for (WebElement currentDate : activeDates) {
            if (currentDate.getText().contains("Today") ||
                    Integer.parseInt(currentDate.getText()) == date) {
                currentDate.click();
                break;
            }
        }
    }

    public void verifyDate(String dateType) {
        WebElement dateField = null;
        switch (dateType) {
            case "dateFrom":
                dateField = driver.findElement(By.name("startDate"));
                Assert.assertNotNull(dateField.getAttribute("value"));
                Assert.assertNotEquals("", dateField.getAttribute("value"));
                break;
            case "dateTo":
                dateField = driver.findElement(By.name("endDate"));
                Assert.assertNotNull(dateField.getAttribute("value"));
                Assert.assertNotEquals("", dateField.getAttribute("value"));
                break;
        }
    }

    public void verifyStatus(String status) {
        WebElement statusField = driver.findElement(By.name("status"));
        Assert.assertEquals(status, statusField.getAttribute("value"));
    }

    public void verifyTableHeaders() {
        int rowsCount = 17;
        WebElement table = driver.findElement(By.id("headercontainer-1090-innerCt"));

        List<WebElement> headers = table.findElements(By.className("x-column-header"));
        for (WebElement header : headers) {
            Assert.assertFalse(header.getText().equals(""));
            Assert.assertNotNull(header.getText());
        }

        Assert.assertEquals(rowsCount, headers.size()); //number of jobs table rows
    }

    public void verifyDownloadButton() {
        WebElement button = driver.findElement(By.id("button-1115-btnInnerEl"));
        Assert.assertEquals("Download statement", button.getText());
    }
}

