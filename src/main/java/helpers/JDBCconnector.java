package helpers;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class JDBCconnector {

    static Configuration config;
    static Map<String, String> db;

    static {
        try {
            config = YamlReader.read("src/test/resources/db.yml", Configuration.class);
            db = config.connection.get("server67");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String url = db.get("url");
    private static final String user = db.get("user");
    private static final String password = db.get("password");

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    static String query = "select top 1 email, mobileId\n" +
            "from drivers as d \n" +
            "join vehicles as v on d.vehicle_id = v.id \n" +
            "join individual_emails as im on d.employee_id = im.individual_id\n" +
            "where driverStatus = 6\n" +
            "and\t  preventAllocation = 0\n" +
            "and   v.status = 0\n" +
            "and   d.depot_id = 4\n" +
            "order by NEWID()\t";

    public JDBCconnector() throws IOException {
    }

    public static String returnValidDriver() {
        String result = "";

        try {
            // opening database connection to MySQL server

            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                result = rs.getString(1) +
                        "," + rs.getString(2);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return result;
    }
}
