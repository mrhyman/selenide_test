package pages.GTCDriverPortal;

import models.GTCDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
        WebElement tableName = driver
               .findElements(By.xpath("//*[contains(@id, 'fieldset') " +
                       "and contains(@id, 'legendTitle') " +
                       "and not(contains(@style, 'display: none'))]"))
               .get(2);
        Assert.assertEquals("Days of the week", tableName.getText());
    }

    public void verifyWeek() {
        List<WebElement> week = driver.findElements(By.xpath("//*[contains(@id, 'driverdayavailabilityform')" +
                "and contains(@id, 'targetEl')]"));
        ArrayList<WebElement> modifiedWeek = new ArrayList<>();
        for (WebElement w: week) {
            if (!w.getText().equals("") || !w.getText().isEmpty()) {
                modifiedWeek.add(w);
            }
        }
        Assert.assertEquals(7, modifiedWeek.size());

    }

    public void verifyWeekNotes() {
        WebElement weekNotes = driver.findElements(By.className("x-vbox-form-item")).get(1);
        WebElement input = weekNotes.findElement(By.name("weekNotes"));
        WebElement label = weekNotes.findElement(By.xpath("//label[contains(@for, '"+input.getAttribute("id")+"')]"));

        Assert.assertEquals("week notes:", label.getText());
        Assert.assertEquals("", input.getAttribute("value"));
    }

    public void verifyButtons() {
        List<WebElement> buttons = driver.findElements(By.xpath("//a[contains(@id, 'button')]"));
        ArrayList<WebElement> visibleButtons = new ArrayList<>();
        for(WebElement el: buttons) {
            if (el.isDisplayed()) {
                visibleButtons.add(el);
            }
        }

        for(WebElement el: visibleButtons) {
            System.out.println(el.getAttribute("id") + " - " + el.getText());
        }

        Assert.assertEquals(10, buttons.size());
    }
}

