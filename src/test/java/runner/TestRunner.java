package runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import tests.driverPortal.FirstJourneyTabTest;
import tests.driverPortal.LoginTest;
import tests.driverPortal.PayslipsTabTest;


public class TestRunner {
    public static void main(String[] args) {
        final Result result =
                JUnitCore.runClasses(
                        LoginTest.class,
                        FirstJourneyTabTest.class,
                        PayslipsTabTest.class
                );

        Logger logger = LogManager.getLogger(Runner.class);
        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }

        if (result.wasSuccessful()) {
            logger.info("Testrun was successful! It took " + result.getRunTime()/1000 + " sec");
        } else {
            logger.info("Testrun failed");
        }
    }
}
