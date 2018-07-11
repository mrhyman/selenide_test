package testCases.driverPortals.GTC;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElements;

public class FirstJourneyTabTest {

    @Test
    public void driverAddressIsShownTest() {
        $("#textfield-1011-inputEl")
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.empty);
    }

    @Test
    public void driverNextShiftIsShownTest() {
        $("#textfield-1012-inputEl")
                .shouldBe(Condition.visible)
                .shouldNotBe(Condition.empty);
    }

    @Test
    public void mapIsShownTest() {
        $("#mapFrame").shouldBe(Condition.visible);
    }

    @Test
    public void jobsTableIsShown() {
        $("#panel-1013").shouldBe(visible);
    }

    @Test
    public void selectFirstJobButtonIsShownTest() {
        if (getElements(By.className("x-grid-row")).size() > 0) {
            $("#button-1014").shouldNotHave(cssClass("x-btn-disabled"));
        } else {
            $("#button-1014").shouldHave(cssClass("x-btn-disabled"));
        }
        $("#button-1014").shouldHave(text("Select"));
    }
}
