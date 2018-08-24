package pages.GTCDriverPortal;

import models.GTCDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class NotPaidJobsTab extends DriverPortalPage {

    public NotPaidJobsTab(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public NotPaidJobsTab(WebDriver driver, WebDriverWait wait, GTCDriver gtcDriver) {
        super(driver, wait, gtcDriver);
    }

    public void clickApplyButton() {
        click(By.id("button-1113"));
    }

    public void openStatusDropDown() {
        click(By.id("combobox-1110-bodyEl"));
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

        for (WebElement el : activeDates) {
            System.out.println(el.getText());
        }

        for (WebElement currentDate : activeDates) {
            if (currentDate.getText().contains("Today")) {
                currentDate.click();
                break;
            } else if (Integer.parseInt(currentDate.getText()) == date){
                currentDate.click();
                break;
            }
        }
    }
}

