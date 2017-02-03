package DAO;

import java.sql.*;

/**
 * Created by Arthur on 19-1-2017.
 */
public class ResourceDatabaseConnection {

    private static final String ORACLE_DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_DB_CONN = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String ORACLE_DB_USER = "tosad_2016_2d_team3";
    private static final String ORACLE_DB_PASS = "tosad_2016_2d_team3";
    //private static final String ORACLE_DB_NAME = "tosad_2016_2d_team3";

    private static Connection con;

    public ResourceDatabaseConnection() {
        this.openConnection();
    }

    public Connection getCon() {
        try {
            int tries = 0;
            while (con.isClosed()) {
                if (tries == 10) break;
                this.openConnection();
                System.out.println("Reconnecting to database");
            }
            tries++;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void setCon(Connection con) {
        ResourceDatabaseConnection.con = con;
    }

    public void openConnection() {
        try {
            Class.forName(ORACLE_DB_DRIV);
            setCon(DriverManager.getConnection(ORACLE_DB_CONN, ORACLE_DB_USER, ORACLE_DB_PASS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}