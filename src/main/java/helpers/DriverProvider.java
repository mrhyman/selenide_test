package helpers;

public class DriverProvider {
    public static Object[] provideValidDrivers() {
        return new Object[]{JDBCconnector.returnValidDriver(), true};
    }
}
