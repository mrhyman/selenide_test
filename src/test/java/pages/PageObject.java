package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void writeText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String readText(By locator){
        return driver.findElement(locator).getText();
    }

    public void deleteText(By locator) {
        driver.findElement(locator).clear();
    }
}
