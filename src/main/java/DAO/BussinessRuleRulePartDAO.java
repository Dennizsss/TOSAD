package DAO;

import Model.BusinessRule;
import Model.RulePart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Arthur on 19-1-2017.
 */
public class BussinessRuleRulePartDAO {

    private DatabaseConnection db;
    private Connection con;

    public BussinessRuleRulePartDAO() {
        this.db = new DatabaseConnection();
        this.con = db.getCon();
    }

    public void createLink(String businessRuleName, ArrayList<RulePart> ruleParts) {
        PreparedStatement insert = null;
        BusinessRule businessRule = null;
        //RulePart rulePart = null;

        BusinessRuleDAO BRDAO = new BusinessRuleDAO();
        RulePartDAO RPDAO = new RulePartDAO();

        businessRule = BRDAO.getBusinessRule(businessRuleName);

        String insertString = "INSERT INTO \"BusinessRuleRulePart\" (\"ID\", \"BusinessRule\", \"RulePart\", \"Condition\", \"OrderNum\") VALUES (\"BussinessRuleRulePartID\".NEXTVAL, ?, ?, ?, ?)";
        // INSERT INTO "RulePart" ("ID", "TableRP", "QueryRP", "Name") VALUES ("RulePartID".NEXTVAL, 'test', 'test', 'test')

        try {
            insert = con.prepareStatement(insertString);

            for (RulePart rulePart: ruleParts) {
                RulePart rulePartSQL = RPDAO.getRulePart(rulePart.getName(), rulePart.getQuery());
                if (!linkExists(businessRuleName, rulePart.getName())) {
                    insert.setInt(1, businessRule.getBr_Id());
                    insert.setInt(2, rulePartSQL.getId());
                    insert.setString(3, rulePart.getCondition());
                    insert.setInt(4, rulePart.getOrder());
                    insert.executeUpdate();
                }
            }

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public boolean linkExists(String businessRuleName, String rulePartName) {
        PreparedStatement select = null;
        BusinessRule businessRule = null;
        RulePart rulePart = null;

        BusinessRuleDAO BRDAO = new BusinessRuleDAO();
        RulePartDAO RPDAO = new RulePartDAO();

        businessRule = BRDAO.getBusinessRule(businessRuleName);
        rulePart = RPDAO.getRulePart(rulePartName);

        if (businessRule == null) {
            return false;
        }

        if (rulePart == null) {
            return false;
        }

        String selectString = "SELECT * FROM \"BusinessRuleRulePart\" WHERE \"BusinessRule\" = ? AND \"RulePart\" = ?";

        try {
            select = con.prepareStatement(selectString);

            select.setInt(1, businessRule.getBr_Id());
            select.setInt(2, rulePart.getId());
            ResultSet rs = select.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return false;
    }
}
