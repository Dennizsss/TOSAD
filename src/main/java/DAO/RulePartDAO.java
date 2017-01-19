package DAO;

import Model.RulePart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 18-1-2017.
 */


public class RulePartDAO {
    private DatabaseConnection db;
    private Connection con;

    public RulePartDAO() {
        this.db = new DatabaseConnection();
        this.con = db.getCon();
    }

    public void createRulePart(RulePart rulePart) {
        PreparedStatement insertRulePart = null;

        String insertString = "INSERT INTO \"RulePart\" (\"ID\", \"TableRP\", \"QueryRP\", \"Name\") VALUES (\"RulePartID\".NEXTVAL, ?, ?, ?)";
        // INSERT INTO "RulePart" ("ID", "TableRP", "QueryRP", "Name") VALUES ("RulePartID".NEXTVAL, 'test', 'test', 'test')

        try {
            insertRulePart = con.prepareStatement(insertString);

            insertRulePart.setString(1, rulePart.getTable());
            insertRulePart.setString(2, rulePart.getQuery());
            insertRulePart.setString(3, rulePart.getName());
            insertRulePart.executeUpdate();

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    /*public void updateRulePart() {
        PreparedStatement updateTotal = null;

        String updateString = "update COFFEES set SALES = ? where COF_NAME = ?";

        try {
            con.setAutoCommit(false);
            updateTotal = con.prepareStatement(updateString);

            updateTotal.setInt(1, e.getValue().intValue());
            updateTotal.setString(2, e.getKey());
            updateTotal.executeUpdate();
            con.commit();

            con.setAutoCommit(true);
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }*/

    public RulePart getRulePart(int id) {
        return null;
    }

    public RulePart getRulePart(String name) {
        return null;
    }

    public RulePart getRulePart(int id, String query) {
        return null;
    }

    public RulePart getRulePart(String name, String query) {
        PreparedStatement selectRP = null;
        RulePart rulePart = null;

        String selectString = "SELECT * FROM \"RulePart\" WHERE \"Name\" = ? AND \"QueryRP\" = ?";

        try {
            selectRP = con.prepareStatement(selectString);

            selectRP.setString(1, name);
            selectRP.setString(2, query);
            ResultSet rs = selectRP.executeQuery();

            rs.next();
            rulePart = new RulePart(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            return rulePart;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<RulePart> getRuleParts() {
        ArrayList<RulePart> ruleparts = new ArrayList<RulePart>();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from RulePart");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
