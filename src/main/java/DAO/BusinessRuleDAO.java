package DAO;

import Model.BusinessRule;
import Model.RulePart;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Arthur on 18-1-2017.
 */
public class BusinessRuleDAO {

    private ResourceDatabaseConnection db;
    private Connection con;
    private RulePartDAO rpDAO;

    public BusinessRuleDAO() {
        this.db = new ResourceDatabaseConnection();
        this.con = db.getCon();
        this.rpDAO = new RulePartDAO();
    }

    public BusinessRule getBusinessRule(int id) {
        BusinessRule businessRule = null;

        String selectString = "SELECT * FROM BUSINESSRULE WHERE ID = ?";

        try {
            PreparedStatement selectBR = con.prepareStatement(selectString);

            selectBR.setInt(1, id);
            ResultSet rs = selectBR.executeQuery();

            if (rs.next()) {
                businessRule = new BusinessRule(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));

                ArrayList<RulePart> ruleParts = rpDAO.getRulePartsFromBrId(businessRule.getId());
                businessRule.setRuleParts(ruleParts);
            }

            return businessRule;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public BusinessRule getBusinessRule(String name) {
        BusinessRule businessRule = null;

        String selectString = "SELECT * FROM BUSINESSRULE WHERE NAME = ?";

        try {
            PreparedStatement selectBR = con.prepareStatement(selectString);

            selectBR.setString(1, name);
            ResultSet rs = selectBR.executeQuery();

            if (rs.next()) {
                businessRule = new BusinessRule(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));

                ArrayList<RulePart> ruleParts = rpDAO.getRulePartsFromBrId(businessRule.getId());
                businessRule.setRuleParts(ruleParts);
            }

            return businessRule;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BusinessRule> getBusinessRules() {
        ArrayList<BusinessRule> businessRules = new ArrayList<BusinessRule>();
        try {
            Statement stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from BUSINESSRULE");
            while(rs.next()) {
                BusinessRule businessRule = new BusinessRule(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));

                ArrayList<RulePart> ruleParts = rpDAO.getRulePartsFromBrId(businessRule.getId());
                businessRule.setRuleParts(ruleParts);

                businessRules.add(businessRule);
            }

            return businessRules;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBusinessRuleApplied(int businessRule, int status) {
        String selectString = "UPDATE BUSINESSRULE SET STATUS = ? WHERE id = ?";

        try {
            PreparedStatement selectBR = con.prepareStatement(selectString);

            selectBR.setInt(1, status);
            selectBR.setInt(2, businessRule);
            selectBR.executeQuery();

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

}