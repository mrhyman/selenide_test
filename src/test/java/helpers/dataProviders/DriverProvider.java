package helpers.dataProviders;

import helpers.JDBCconnector;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverProvider {
    public static Object[] provideInvalidDriver() {
        return new Object[]{JDBCconnector.returnDriver(JDBCconnector.InvalidDriverQuery), false};
    }
    public static Object[] provideValidDriver() {
        return new Object[]{JDBCconnector.returnDriver(JDBCconnector.validDriverQuery), true};
    }
}
