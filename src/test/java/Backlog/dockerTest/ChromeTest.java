package Backlog.dockerTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest {
    public static RemoteWebDriver chrome;
    @Before
    public void setUp() throws MalformedURLException {
        Capabilities chromeCapabilities = DesiredCapabilities.chrome();
        chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
    }
    @Test
    public void runChrome() {
        chrome.get("https://www.google.com");
        System.out.println(chrome.getTitle());
    }

    @After
    public void closeChrome() {
        chrome.quit();
    }
}