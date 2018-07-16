package testCases.driverPortals.GTC;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GTCDriverPortal {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"greentomatocars - Driver Portal", "driverportal@greentomatocars.com"}
        });
    }

    @Parameterized.Parameter
    public String title;

    @Parameterized.Parameter(1)
    public String email;

    @Test
    public void correctTitleIsShownTest() {
        assertEquals(title, title());
    }

    @Test
    public void supportEmailIsShownTest(){
        $(byText(email))
                .shouldBe(visible)
                .shouldHave(attribute("href",
                        "mailto:" + email));
    }
}
