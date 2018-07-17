package helpers;

public class SqlConnection {
    private static String url;
    private static String user;
    private static String password;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        SqlConnection.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        SqlConnection.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SqlConnection.password = password;
    }

}
