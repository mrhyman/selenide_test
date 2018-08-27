package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AvailabilityTab extends DriverPortalPage {
    public AvailabilityTab(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AvailabilityTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void verifyURL() {
        Assert.assertEquals("https://192.0.2.67/driver-portal/#availability", driver.getCurrentUrl()); //hardcoded IP
    }

    public void verifyDairyHeader() {
        WebElement header = driver.findElement(
                By.xpath("//span[contains(text(), 'Current week')]"));
        Assert.assertNotNull(header);
        Assert.assertNotEquals("", header.getText());
    }

    public void verifyDairyTableName() {
        List<WebElement> tableNames = driver
               .findElements(By.xpath("//div[contains(@id, legendTitle)][string-length(text()) > 5]"));
//                .findElements(By.xpath("//*[contains(text(), 'week')]"));
//        [contains(text(), 'Days of the week')]
        for (WebElement el : tableNames) {
            System.out.println(el.getAttribute("id") + " - " + el.getText());
        }
//
//        System.out.println(tableNames.getAttribute("id"));
        Assert.assertEquals("Days of the week", tableNames.get(0).getText());
    }

    public void verifyWeek() {
        WebElement dairy = driver.findElement(By.id("fieldset-2002-body"));
        List<WebElement> week = dairy.findElements(By.className("x-panel"));
        Assert.assertEquals(7, week.size());

    }
}

