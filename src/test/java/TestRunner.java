import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.LoginTest;


public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LoginTest.class);
        Logger logger = LogManager.getLogger(TestRunner.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }

        logger.info(result.wasSuccessful());
    }
}