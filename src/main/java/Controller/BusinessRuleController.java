package Controller;

import Model.RulePart;
import Model.BusinessRule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

import static java.lang.Math.toIntExact;
import static spark.Spark.*;

public class BusinessRuleController {

    private BusinessRule businessRule = new BusinessRule();
    private ArrayList<RulePart> ruleParts = new ArrayList<RulePart>();

    public void parseData(String jsonObject) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(jsonObject);
            JSONObject object = (JSONObject) obj;
            JSONArray rulepartsArr = (JSONArray) object.get("ruleparts");
            for (Object rulepartObject : rulepartsArr) {
                JSONObject rulepartJSONObject = (JSONObject) rulepartObject;

                String name = (String) rulepartJSONObject.get("name");
                String table = (String) rulepartJSONObject.get("table");
                String query = (String) rulepartJSONObject.get("query");
                String condition = (String) rulepartJSONObject.get("condition");
                int order = toIntExact((Long) rulepartJSONObject.get("order"));

                RulePart rulePart = new RulePart(name, table, query, order, condition);
                ruleParts.add(rulePart);
                System.out.println(rulepartObject.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
