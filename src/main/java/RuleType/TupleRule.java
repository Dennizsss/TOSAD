package RuleType;

import Model.RulePart;

/** Restriction on two or more attributes within a row
 * Shape: Entity - Operator - Column - Expression - Entity - Operator - Column
 * Example: Employee where EmployeeName = "Sales" must have commision
 */
public class TupleRule implements RuleType {
    private String column;
    private String operator;
    private String otherColumn;
    private String valueType;

    private String condition;

    private String not;

    public Object makeRuleType() {
        return this;
    }

    public String generateStatement(RulePart rulePart) {
        String statement = "(";

        column = rulePart.getColumnName();
        operator = rulePart.getOperator();
        valueType = rulePart.getValueType();
        otherColumn = rulePart.getOtherColumn();
        if (rulePart.getNotTag() == 0) not = "";
        else not = "";
        //else not = "NOT";
        if (!rulePart.getCondition().matches("NULL")) condition = rulePart.getCondition();
        else condition = "";

        statement = statement + column + " " + not + " " + operator + " " + otherColumn + ") " + condition;

        return statement;
    }
}
