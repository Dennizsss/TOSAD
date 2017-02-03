package RuleType;

import Model.RulePart;

import javax.persistence.Convert;
import java.util.ArrayList;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeCompareRule implements RuleType {
    private String column;
    private String value;
    private String operator;
    private String valueType;

    private String condition;

    private String not;

    public Object makeRuleType() {
        return this;
    }

    public String generateStatement(RulePart rulePart) {
        String statement = "(";

        column = rulePart.getColumnName();
        value = rulePart.getValue();
        operator = rulePart.getOperator();
        valueType = rulePart.getValueType();
        //if (rulePart.getNotTag() == 0) not = ""; else not =  ""; //else not =  "NOT";
        if (!rulePart.getCondition().matches("NULL")) condition = rulePart.getCondition(); else condition = "";

        statement = statement + column + " " + operator + " ";

        if (valueType.matches("Number")) {
            statement = statement + Integer.parseInt(value);
        } else if (valueType.matches("Date")) {

        } else if (valueType.matches("String")) {
            statement = statement + value;
        }


        statement = statement + ") " + condition;

        return statement;
    }

    public ArrayList<String> generateTrigger(RulePart rulePart) {
        return new ArrayList<>();
    }
}

