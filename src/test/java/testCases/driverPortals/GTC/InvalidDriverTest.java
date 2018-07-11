package testCases.driverPortals.GTC;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.driverPortal.gtc.GTCDriverLoginPage;
import testData.drivers.InvalidDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class InvalidDriverTest extends GTCDriverPortal {

    @BeforeClass
    public static void invalidLogin() {
        GTCDriverLoginPage.invalidLogin(new InvalidDriver());
    }

    @Test
    public void emailFieldIsShownTest() {
        $("#email").shouldBe(visible);
        assert getElement(By.cssSelector("#email")).getAttribute("placeHolder").equals("email");
    }

    @Test
    public void emailLabelIsShownTest() {
        $(byText("email"))
                .shouldBe(visible)
                .shouldHave(attribute("required"));
    }

    @Test
    public void pinFieldIsShownTest() {
        $("#password").shouldBe(visible);
        assert getElement(By.cssSelector("#password")).getAttribute("placeHolder").equals("PIN");
    }

    @Test
    public void pinLabelIsShownTest() {
        $(byText("PIN"))
                .shouldBe(visible)
                .shouldHave(attribute("required"));;
    }

    @Test
    public void rememberCheckboxIsShownTest() {
        $(byName("_spring_security_remember_me"))
                .shouldBe(visible)
                .shouldNotBe(selected);
    }

    @Test
    public void rememberLabelIsShownTest() {
        $(byText("remember me:")).shouldBe(visible);
    }

    @Test
    public void loginButtonIsShownTest() {
        $(byText("login"))
                .shouldBe(visible)
                .shouldBe(enabled);
    }

    @Test
    public void errorMessageIsShown() {
        $(byText("Invalid email or password")).shouldBe(visible);
    }

    @Test
    public void logoIsShownTest(){
        $(byXpath("/html/body/div[1]/img")).isImage();
    }

    @Test
    public void logoHeaderIsShownTest(){
        $(byClassName("lgn-online-booking"))
                .shouldBe(visible)
                .shouldHave(text("driver portal"));
    }

    @Test
    public void formHeaderIsShownTest(){
        $(byClassName("lgn-header-label"))
                .shouldBe(visible)
                .shouldHave(text("please enter email and PIN"));
    }

    @Test
    public void supportFooterIsShownTest(){
        $(byClassName("lgn-header-support"))
                .shouldBe(visible)
                .shouldHave(text("*if you are having trouble logging in then please contact "));
    }

}
