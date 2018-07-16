import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTest {


    static Capabilities firefoxCapabilities = DesiredCapabilities.firefox();

    public static void main() throws MalformedURLException {

        RemoteWebDriver firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);

        // run against chrome


        // run against firefox
        firefox.get("https://www.google.com");
        System.out.println(firefox.getTitle());

        firefox.quit();
    }
}