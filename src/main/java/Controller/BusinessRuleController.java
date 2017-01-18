package Controller;

import Model.RulePart;
import Model.BusinessRule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

import static java.lang.Math.toIntExact;

public class BusinessRuleController {

    private BusinessRule businessRule;
    private ArrayList<RulePart> ruleParts = new ArrayList<RulePart>();

    public void parseData(String jsonObject) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(jsonObject);

            // converting bussinesrule from JSON to java object
            JSONObject businessRule = (JSONObject) object.get("businessrule");
            String BRName = (String) businessRule.get("name");
            String description = (String) businessRule.get("description");
            int status = toIntExact((Long) businessRule.get("enabled"));

            this.businessRule = new BusinessRule(BRName, description, status);

            // converting ruleparts from JSON to Java objects
            JSONArray rulepartsArr = (JSONArray) object.get("ruleparts");
            for (Object rulepartObject : rulepartsArr) {
                JSONObject rulepartJSONObject = (JSONObject) rulepartObject;

                String RPName = (String) rulepartJSONObject.get("name");
                String table = (String) rulepartJSONObject.get("table");
                String query = (String) rulepartJSONObject.get("query");
                String condition = (String) rulepartJSONObject.get("condition");
                int order = toIntExact((Long) rulepartJSONObject.get("order"));

                RulePart rulePart = new RulePart(RPName, table, query, order, condition);
                ruleParts.add(rulePart);
            }

            this.businessRule.setRuleParts(ruleParts);
            String lol = "test";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String generateDDL() {
        String DDL = "ALTER TABLE FILLINTABLETHINGY ADD CONSTRAINT ";


        DDL = DDL + this.businessRule.getName() + " CHECK (";

        int i = 1;
        boolean replace = false;

        for (RulePart rulePart: this.ruleParts) {
            if (!replace) {
                DDL = DDL.replaceFirst("FILLINTABLETHINGY", rulePart.getTable());
                replace = true;
            }

            if (rulePart.getOrder() == i) {
                DDL = DDL + rulePart + " ";
                i++;
            }
        }

        DDL = DDL + ")";

        // ALTER TABLE Persons ADD CONSTRAINT chk_Person CHECK (P_Id>0 AND City='Sandnes')
        return DDL;
    }
}
