package DAO;

import Model.BusinessRule;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by Arthur on 18-1-2017.
 */
public class BusinessRuleDAO {

    private DatabaseConnection db;
    private Connection con;

    public BusinessRuleDAO() {
        this.db = new DatabaseConnection();
        this.con = db.getCon();
    }

    public void createBusinessRule(BusinessRule businessRule) {
        PreparedStatement insertBusinessRule = null;

        String insertString = "INSERT INTO \"BusinessRule\" (\"ID\", \"Name\", \"Description\", \"Status\") VALUES (\"BussinessRuleID\".NEXTVAL, ?, ?, ?)";
        // INSERT INTO "RulePart" ("ID", "TableRP", "QueryRP", "Name") VALUES ("RulePartID".NEXTVAL, 'test', 'test', 'test')

        try {
            insertBusinessRule = con.prepareStatement(insertString);

            insertBusinessRule.setString(1, businessRule.getName());
            insertBusinessRule.setString(2, businessRule.getDescription());
            insertBusinessRule.setInt(3, businessRule.getStatus());
            insertBusinessRule.executeUpdate();

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public BusinessRule getBusinessRule(int id) {
        return null;
    }

    public BusinessRule getBusinessRule(String name) {
        PreparedStatement selectBR = null;
        BusinessRule businessRule = null;

        String selectString = "SELECT * FROM \"BusinessRule\" WHERE \"Name\" = ?";

        try {
            selectBR = con.prepareStatement(selectString);

            selectBR.setString(1, name);
            ResultSet rs = selectBR.executeQuery();

            if (rs.next()) {
                businessRule = new BusinessRule(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

            return businessRule;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BusinessRule> getBusinessRules() {
        return null;
    }

}
