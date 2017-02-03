package RuleType;

import Model.RulePart;

import java.util.ArrayList;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeRangeRule implements RuleType {
    private String column;
    private String operator;
    private String condition;

    private int min;
    private int max;

    private String not;

    public Object makeRuleType() {
        return this;
    }

    public String generateStatement(RulePart rulePart) {
        String statement = "(";

        column = rulePart.getColumnName();
        min = rulePart.getMin();
        max = rulePart.getMax();
        operator = rulePart.getOperator();
        if (rulePart.getNotTag() == 0) not = ""; else not =  "NOT";
        if (!rulePart.getCondition().matches("NULL")) condition = rulePart.getCondition(); else condition = "";

        statement = statement + column + " " + not + " " + operator + " " + min + " AND " + max;


        statement = statement + ") " + condition;

        return statement;
    }

    public ArrayList<String> generateTrigger(RulePart rulePart) {
        return new ArrayList<>();
    }
}

