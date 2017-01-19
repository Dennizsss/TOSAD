package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Arthur on 19-1-2017.
 */
public class DatabaseConnection {

    private static final String ORACLE_DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_DB_CONN = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String ORACLE_DB_USER = "tosad_2016_2d_team3";
    private static final String ORACLE_DB_PASS = "tosad_2016_2d_team3";
    //private static final String ORACLE_DB_NAME = "tosad_2016_2d_team3";

    private static Connection con;

    public DatabaseConnection() {
        int tries = 0;

        if (this.getCon() != null) {
            while (this.isClosed()) {
                if (tries == 5) break;
                this.openConnection();
                tries++;
            }
        } else {
            this.openConnection();
        }
    }

    public Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DatabaseConnection.con = con;
    }

    public boolean isClosed() {
        try {
            if (this.getCon().isClosed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
