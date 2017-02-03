package Test;

import Controller.BusinessRuleController;
import DAO.BusinessRuleDAO;
import DAO.ResourceDatabaseConnection;
import DAO.RulePartDAO;
import DAO.TargetDatabaseConnection;
import Model.BusinessRule;
import Model.RulePart;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import org.hibernate.sql.ordering.antlr.Factory;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arthur on 26-1-2017.
 */
public class Main {
	public static void main(String[] args) {
		RulePartDAO rpDAO = new RulePartDAO();
        BusinessRuleDAO brDAO = new BusinessRuleDAO();
        TargetDatabaseConnection targetDatabaseConnection = new TargetDatabaseConnection();

//        ArrayList<RulePart> ruleParts = rpDAO.getRuleParts();
//
//        for (RulePart rulePart: ruleParts) {
//            System.out.print("Id " + rulePart.getId() + " + ");
//            System.out.print("Name " + rulePart.getName() + " + ");
//            System.out.println("Tablename " + rulePart.getTableName() + " + ");
//        }

//        RulePart rp = rpDAO.getRulePart(4);
//        System.out.print("Id " + rp.getId() + " + ");
//        System.out.print("Name " + rp.getName() + " + ");
//        System.out.println("Tablename " + rp.getTableName() + " + ");

//        ArrayList<BusinessRule> businessRules = brDAO.getBusinessRules();
//
//        for (BusinessRule businessRule: businessRules) {
//            System.out.print("Id " + businessRule.getId() + " + ");
//            System.out.print("Name " + businessRule.getName() + " + ");
//            System.out.println("Desc " + businessRule.getDescription() + " + ");
//        }
//
//        BusinessRule businessRule = brDAO.getBusinessRule(666);
//        System.out.print("Id " + businessRule.getId() + " + ");
//        System.out.print("Name " + businessRule.getName() + " + ");
//        System.out.println("Desc " + businessRule.getDescription() + " + ");
//
//        for (RulePart rulePart: businessRule.getRuleParts()) {
//            System.out.print("Id " + rulePart.getId() + " + ");
//            System.out.print("Name " + rulePart.getName() + " + ");
//            System.out.println("Tablename " + rulePart.getRuleType() + " + ");
//        }

//        BusinessRuleController businessRuleController = new BusinessRuleController();
//
//        int businessRuleId = 666;
//        BusinessRule businessRule = brDAO.getBusinessRule(businessRuleId);
//
//        ArrayList<BusinessRule> businessRules = brDAO.getBusinessRules();

//        for (BusinessRule businessRule : businessRules) {
//            if (businessRule.getStatus() == 0 && businessRule.getId() == 666) {
//                if (businessRule.getRuleParts().size() > 0) {
//                    String tableName = businessRule.getRuleParts().get(0).getTableName();
//                    String DDL = businessRuleController.generateDDL(businessRule);
//                    System.out.println(DDL);
//
//                    targetDatabaseConnection.dropBusinessRule(businessRule.getName(), tableName);
//
//                    String message = targetDatabaseConnection.applyBusinessRule(DDL);
//                    if (message.matches("ok")) {
//                        brDAO.setBusinessRuleApplied(businessRule.getId(), 1);
//                    } else {
//                        brDAO.setBusinessRuleApplied(businessRule.getId(), 3);
//                    }
//                } else {
//                    System.out.println("No ruleparts, this means it is not a full businessrule");
//                    brDAO.setBusinessRuleApplied(businessRule.getId(), 3);
//                }
//            }
//        }

        BusinessRuleController businessRuleController = new BusinessRuleController();
        BusinessRule businessRule = brDAO.getBusinessRule(71);
        String DDL = businessRuleController.generateDDL(businessRule);
        System.out.println(DDL);


//
//        String test = businessRuleController.generateDDL2(businessRule);
//        System.out.println(test);
//        businessRuleController.disableBusinessRule(666);
//        businessRuleController.enableBusinessRule(666);


	}
}
