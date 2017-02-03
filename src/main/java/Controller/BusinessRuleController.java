package Controller;


import DAO.BusinessRuleDAO;
import DAO.RulePartDAO;
import DAO.TargetDatabaseConnection;
import Model.RulePart;
import Model.BusinessRule;
import RuleType.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.toIntExact;

public class BusinessRuleController {

    private BusinessRuleDAO BRDAO;
    private RulePartDAO RPDAO;
    private TargetDatabaseConnection TDCON;

    public BusinessRuleController() {
        BRDAO = new BusinessRuleDAO();
        RPDAO = new RulePartDAO();
        TDCON = new TargetDatabaseConnection();
    }

    public void applyBusinessRule(int businessRuleId) {
        BusinessRule businessRule = BRDAO.getBusinessRule(businessRuleId);
        if (businessRule.getStatus() == 0 && businessRule.getRuleParts().size() > 0) {
            String tableName = businessRule.getRuleParts().get(0).getTableName();
            String DDL = generateDDL(businessRule);
            System.out.println(DDL);

            TDCON.dropBusinessRule(businessRule.getName(), tableName);

            String message = TDCON.applyBusinessRule(DDL);
            if (message.matches("ok")) {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 1);
            } else {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
            }
        } else {
            System.out.println("No ruleparts, this means it is not a full businessrule");
            BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
        }
    }

    public void enableBusinessRule(int businessRuleId) {
        BusinessRule businessRule = BRDAO.getBusinessRule(businessRuleId);
        if (businessRule.getRuleParts().size() > 0) {
            String tableName = businessRule.getRuleParts().get(0).getTableName();
            String message = TDCON.enableBusinessRule(businessRule.getName(), tableName);
            if (message.matches("ok")) {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 1);
            } else {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
            }
        } else {
            System.out.println("No ruleparts, this means it is not a full businessrule");
            BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
        }
    }

    public void disableBusinessRule(int businessRuleId) {
        BusinessRule businessRule = BRDAO.getBusinessRule(businessRuleId);
        if (businessRule.getRuleParts().size() > 0) {
            String tableName = businessRule.getRuleParts().get(0).getTableName();
            String message = TDCON.disableBusinessRule(businessRule.getName(), tableName);
            if (message.matches("ok")) {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 2);
            } else {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
            }
        } else {
            System.out.println("No ruleparts, this means it is not a full businessrule");
            BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
        }
    }

    public void dropBusinessRule(int businessRuleId) {
        BusinessRule businessRule = BRDAO.getBusinessRule(businessRuleId);
        if (businessRule.getRuleParts().size() > 0) {
            String tableName = businessRule.getRuleParts().get(0).getTableName();
            String message = TDCON.dropBusinessRule(businessRule.getName(), tableName);
            if (message.matches("ok")) {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 0);
            } else {
                BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
            }
        } else {
            System.out.println("No ruleparts, this means it is not a full businessrule");
            BRDAO.setBusinessRuleApplied(businessRule.getId(), 3);
        }
    }

    public String generateDDL(BusinessRule businessRule) {
        String DDL = "ALTER TABLE FILLINTABLETHINGY ADD CONSTRAINT " + businessRule.getName() + "_CHK CHECK (";


        ArrayList<RulePart> ruleParts = businessRule.getRuleParts();

        int i = 1;
        boolean replace = false;
        Map<Integer, String> parts = new HashMap<>();

        for (RulePart rulePart : ruleParts) {
            if (!replace) {
                DDL = DDL.replaceFirst("FILLINTABLETHINGY", rulePart.getTableName());
                replace = true;
            }

            RuleType ruleType = null;

            if (rulePart.getRuleType().matches("Attribute Compare Rule")) {
                ruleType = new AttributeCompareRule();
            } else if (rulePart.getRuleType().matches("Attribute Range Rule")) {
                ruleType = new AttributeRangeRule();
            } else if (rulePart.getRuleType().matches("Attribute List Rule")) {
                ruleType = new AttributeListRule();
            } else if (rulePart.getRuleType().matches("Tuple Compare Rule")) {
                ruleType = new TupleRule();
            } else if (rulePart.getRuleType().matches("Inter-Entity Compare Rule")) {
                ruleType = new InterEntityRule();
            }

            parts.put(rulePart.getSequence(), ruleType.generateStatement(rulePart));

            i++;
        }

        for (int count = 1; count < i; count++) {
            DDL = DDL + " " + parts.get(count - 1);
        }

        DDL = DDL + ")";

        //System.out.println(DDL);
        return DDL;
    }

    public String generateDDL2(BusinessRule businessRule) {
        return "";
    }
}
