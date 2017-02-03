package DAO;

import Model.RulePart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 18-1-2017.
 */


public class RulePartDAO {
    private ResourceDatabaseConnection db;
    private Connection con;

    public RulePartDAO() {
        this.db = new ResourceDatabaseConnection();
        this.con = db.getCon();
    }

    public RulePart getRulePart(int id) {
        RulePart rulePart = null;
        String selectString = "SELECT ID,NAME,TABLENAME,COLUMNNAME,NOTTAG,OPERATE,VALUE,VALUETYPE,MINI,MAXI,OTHERCOLUMN,OTHERTABLE,RULETYPE FROM RULEPART WHERE ID = ?";

        try {
            PreparedStatement selectRP = con.prepareStatement(selectString);

            selectRP.setInt(1, id);
            ResultSet rs = selectRP.executeQuery();

            if (rs.next()) {
                rulePart = new RulePart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
            }

            return rulePart;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public RulePart getRulePart(String name) {
        RulePart rulePart = null;

        String selectString = "SELECT ID,NAME,TABLENAME,COLUMNNAME,NOTTAG,OPERATE,VALUE,VALUETYPE,MINI,MAXI,OTHERCOLUMN,OTHERTABLE,RULETYPE FROM RULEPART WHERE NAME = ?";

        try {
            PreparedStatement selectRP = con.prepareStatement(selectString);

            selectRP.setString(1, name);
            ResultSet rs = selectRP.executeQuery();

            rulePart = new RulePart(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13));

            //rs.next();

            return rulePart;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<RulePart> getRulePartsFromBrId(int id) {
        ArrayList<RulePart> ruleparts = new ArrayList<RulePart>();

        String selectString = "SELECT RP.ID,RP.NAME,RP.TABLENAME,RP.COLUMNNAME,RP.NOTTAG,RP.OPERATE,RP.VALUE,RP.VALUETYPE,RP.MINI,RP.MAXI,RP.OTHERCOLUMN,RP.OTHERTABLE,RC.CONDITION,RC.SEQUENCE,RT.NAME FROM RULEPART RP, BUSINESSRULE BR, RULECONSTRUCTION RC, RULETYPE RT WHERE RT.ID = RP.RULETYPE AND RP.ID = RC.RULEPART AND BR.ID = RC.BUSINESSRULE AND BR.ID = ?";

        try {
            PreparedStatement selectRP = con.prepareStatement(selectString);

            selectRP.setInt(1, id);
            ResultSet rs = selectRP.executeQuery();

            while(rs.next()) {
                RulePart rulePart = new RulePart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(15),
                        rs.getString(13),
                        rs.getInt(14));

                ruleparts.add(rulePart);
            }

            return ruleparts;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<RulePart> getRuleParts() {
        ArrayList<RulePart> ruleparts = new ArrayList<RulePart>();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("select ID,NAME,TABLENAME,COLUMNNAME,NOTTAG,OPERATE,VALUE,VALUETYPE,MINI,MAXI,OTHERCOLUMN,OTHERTABLE,RULETYPE from RulePart");
            while(rs.next()) {
                RulePart rulePart = new RulePart(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));

                ruleparts.add(rulePart);
            }

            return ruleparts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ruleTypes() {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select NAME FROM RULETYPE");
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}