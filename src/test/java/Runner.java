import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.driverPortal.FirstJourneyTabTest;
import tests.driverPortal.LoginTest;

public class Runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LoginTest.class, FirstJourneyTabTest.class);
        Logger logger = LogManager.getLogger(Runner.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }

        logger.info(result.wasSuccessful());
    }
}