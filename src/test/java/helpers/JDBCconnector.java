package helpers;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class JDBCconnector {

    static Configuration config;
    static Map<String, String> db;
    static Map<String, String> names;

    static {
        try {
            config = YamlReader.read("src/test/resources/db.yml", Configuration.class);
            db = config.db;
            names = config.names;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String url = db.get("url") + names.get("server67");
    private static final String user = db.get("user");
    private static final String password = db.get("password");

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public final static String validDriverQuery = "select top 1 email, mobileId\n" +
            "from drivers as d \n" +
            "join vehicles as v on d.vehicle_id = v.id \n" +
            "join individual_emails as im on d.employee_id = im.individual_id\n" +
            "where driverStatus = 6\n" +
            "and\t  preventAllocation = 0\n" +
            "and   v.status = 0\n" +
            "and   d.depot_id = 4\n" +
            "order by NEWID()\t";

    public final static String InvalidDriverQuery = "select top 1 email, mobileId \n" +
            "from drivers as d \n" +
            "join individual_emails as im on d.employee_id = im.individual_id\n" +
            "where d.vehicle_id is null\n" +
            "order by NEWID()";

    public JDBCconnector() {
    }

    public static String returnDriver(String DriverQuery) {
        String result = "";

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(DriverQuery);

            while (rs.next()) {
                result = rs.getString(1) +
                        "," + rs.getString(2);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {}
            try { stmt.close(); } catch(SQLException se) {}
            try { rs.close(); } catch(SQLException se) {}
        }
        return result;
    }
}
