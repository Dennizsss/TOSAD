package RuleType;

import Model.RulePart;

import java.util.ArrayList;
import java.util.List;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeListRule implements RuleType {
    private String column;
    private String operator;
    private String condition;
    private String value;

    public Object makeRuleType() {
        return this;
    }

    public String generateStatement(RulePart rulePart) {
        String statement = "(";

        column = rulePart.getColumnName();
        value = rulePart.getValue();
        operator = rulePart.getOperator();
        if (!rulePart.getCondition().matches("NULL")) condition = rulePart.getCondition(); else condition = "";

        String[] seperated = value.split(",");
        String newStart = "(";
        boolean first = true;
        for (String val: seperated) {
            if (first) {
                newStart = newStart + " '" + val + "'";
                first = false;
            } else {
                newStart = newStart + ", '" + val + "'";
            }
        }
        newStart = newStart + ")";

        statement = statement + column + " " + operator + " " +  newStart;


        statement = statement + ") " + condition;

        return statement;
    }

    public ArrayList<String> generateTrigger(RulePart rulePart) {
        return new ArrayList<>();
    }
}

