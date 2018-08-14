import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.driverPortal.FirstJourneyTabTest;
import tests.driverPortal.LoginTest;


public class TestRunner {
    public static void main(String[] args) {
        final Result result =
                JUnitCore.runClasses(
                        LoginTest.class,
                        FirstJourneyTabTest.class
                );
        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
