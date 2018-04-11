package helpers;

import java.sql.*;
import java.util.ArrayList;

public class JDBCconnector {
    private static final String url = "jdbc:sqlserver://192.0.2.142:1433;databaseName=qa_core_67";
    private static final String user = "sa";
    private static final String password = "GaRptING5109";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    static String query = "select * from driver_working_calendars where working_week_id = '400486' order by id desc";

    public static void returnQuery() {
        try {
            // opening database connection to MySQL server

            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("calendar"));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}
