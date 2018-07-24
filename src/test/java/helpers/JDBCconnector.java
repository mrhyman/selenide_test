package helpers;

import models.GTCDriver;

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

    public final static String validDriverQuery =
            "select top 1 email, mobileId, fullName, home_address_id, useDepotAddress\n" +
                    "from drivers as d \n" +
                    "join vehicles as v on d.vehicle_id = v.id \n" +
                    "join individual_emails as im on d.employee_id = im.individual_id\n" +
                    "join individuals as i on im.individual_id = i.id\n" +
                    "where driverStatus = 8\n" +
                    "and preventAllocation = 0\n" +
                    "and v.status = 0\n" +
                    "and d.depot_id = 4\n" +
                    "order by NEWID()";

    public final static String invalidDriverQuery =
            "select top 1 email, mobileId \n" +
            "from drivers as d \n" +
            "join individual_emails as im on d.employee_id = im.individual_id\n" +
            "where d.vehicle_id is null\n" +
            "order by NEWID()";

    public final static String depotAddress =
            "select fullStr from addresses where id in (\n" +
            "select address_id from depots where id = 4)";

    public final static String driverAddress =
            "select fullStr from addresses where id=";

    public static GTCDriver getGTCDriver(String driverQuery) {
        GTCDriver gtcDriver = new GTCDriver();

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(driverQuery);

            while (rs.next()) {
                gtcDriver.setEmail(rs.getString(1));
                gtcDriver.setMobileId(rs.getString(2));
                if (driverQuery.contains("preventAllocation = 0")) {
                    gtcDriver.setFullName(rs.getString(3));
                    gtcDriver.setAddress(rs.getString(4));
                    gtcDriver.setUseDepotAddress(new Boolean(rs.getString(5)));
                }
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {}
            try { stmt.close(); } catch(SQLException se) {}
            try { rs.close(); } catch(SQLException se) {}
        }
        return gtcDriver;
    }

    public static void getAddress(GTCDriver gtcDriver) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            if (gtcDriver.getUseDepotAddress()) {
                rs = stmt.executeQuery(depotAddress);
            } else {
                rs = stmt.executeQuery(driverAddress + gtcDriver.getAddress());
            }

            while (rs.next()) {
                gtcDriver.setAddress(rs.getString(1));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {}
            try { stmt.close(); } catch(SQLException se) {}
            try { rs.close(); } catch(SQLException se) {}
        }
    }
}
