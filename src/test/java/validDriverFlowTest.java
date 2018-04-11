import com.codeborne.selenide.Condition;
import org.junit.BeforeClass;
import org.junit.Test;
import testData.drivers.validDriver;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class validDriverFlowTest extends driverFlowTest{

    @BeforeClass
    public static void login() {
        $("#email").setValue(validDriver.EMAIL);
        $("#password").setValue(validDriver.PIN);
        $(byName("_spring_security_remember_me")).click();
        $(byText("login")).click();
    }

    @Test
    public void menuTabsAreShownTest() {
        //$("#loadmask-1218-msgEl").waitUntil(Condition.disappears, 10000);
        $("#tab-1211-btnInnerEl").shouldBe(Condition.visible);
        $("#tab-1212-btnInnerEl").shouldBe(Condition.visible);
        $("#tab-1213-btnInnerEl").shouldBe(Condition.visible);
        $("#tab-1214-btnInnerEl").shouldBe(Condition.visible);
        $("#tab-1215-btnInnerEl").shouldBe(Condition.visible);
        $("#tab-1216-btnInnerEl").shouldBe(Condition.visible);
    }

    @Test
    public void driverDetailsAreShownTest() {
        $("#jobtoselectfilterform-1010").shouldBe(Condition.visible);
        $("#textfield-1011-inputEl")
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.empty);
        $("#textfield-1012-inputEl")
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.empty);
    }
}
