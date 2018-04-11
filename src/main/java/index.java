import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class index {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
    }


}

