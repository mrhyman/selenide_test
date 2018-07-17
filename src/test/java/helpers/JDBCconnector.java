package helpers;

import java.sql.*;

public class JDBCconnector {

    private static final String url = YamlReader.connection.;
    private static final String user = SqlConnection.getUser();
    private static final String password = SqlConnection.getPassword();

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
