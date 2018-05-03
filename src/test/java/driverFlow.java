import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class driverFlow {

    @Test
    public void correctTitleIsShownTest() {
        assertEquals("greentomatocars - Driver Portal", title());
    }

    @Test
    public void supportEmailIsShownTest(){
        $(byXpath("//a[text() = 'driverportal@greentomatocars.com']")).shouldBe(visible);
    }
}
