package GTCDriver;

import Pages.GTCDriverPortal.LoginPage;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.title;

import static org.junit.Assert.assertEquals;

public class driverFlowTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeClass
    public static void openDriverPortal() {
        driver = new ChromeDriver();
        driver.get("https://192.0.2.67/driver-portal/login");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public static void logout() {
        driver.close();
    }

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Test
    public void correctTitleIsShownTest() {
        assertEquals(loginPage.getTitle(),"greentomatocars - Driver Portal", title());
    }
}
