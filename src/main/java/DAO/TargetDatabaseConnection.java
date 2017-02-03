package DAO;

import java.sql.*;

/**
 * Created by Arthur on 19-1-2017.
 */
public class TargetDatabaseConnection {

    private static final String ORACLE_DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_DB_CONN = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String ORACLE_DB_USER = "tosad_2016_2d_team3";
    private static final String ORACLE_DB_PASS = "tosad_2016_2d_team3";
    private static final String ORACLE_DB_NAME = "tosad_2016_2d_team3";

    private static Connection con;

    public TargetDatabaseConnection() {
        this.openConnection();
    }

    public Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        TargetDatabaseConnection.con = con;
    }

    public void openConnection() {
        try {
            Class.forName(ORACLE_DB_DRIV);
            Connection connection = DriverManager.getConnection(ORACLE_DB_CONN, ORACLE_DB_USER, ORACLE_DB_PASS);
            connection.setSchema(ORACLE_DB_NAME);
            setCon(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String applyBusinessRule(String DDL) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeQuery(DDL);
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String enableBusinessRule(String businessRuleName, String tableName) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeQuery("ALTER TABLE " + tableName + " ENABLE CONSTRAINT " + businessRuleName + "_CHK");
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String dropBusinessRule(String businessRuleName, String tableName) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeQuery("ALTER TABLE " + tableName + " DROP CONSTRAINT " + businessRuleName + "_CHK");
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String disableBusinessRule(String businessRuleName, String tableName) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeQuery("ALTER TABLE " + tableName + " DISABLE CONSTRAINT " + businessRuleName + "_CHK");
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}