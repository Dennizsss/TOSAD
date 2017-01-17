package RuleType;

/** Restriction on two or more attributes within a row
 * Shape: Entity - Operator - Column - Expression - Entity - Operator - Column
 * Example: Employee where EmployeeName = "Sales" must have commision
 */
public class TupleRule implements RuleType {
    private String  firstEntity,
                    secondEntity,
                    firstColumn,
                    secondColumn,
                    firstOperator,
                    secondOperator,
                    expression;

    public Object makeRuleType(){
        return this;
    }
}
