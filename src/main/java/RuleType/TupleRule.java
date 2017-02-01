package RuleType;

/** Restriction on two or more attributes within a row
 * Shape: Entity - Operator - Column - Expression - Entity - Operator - Column
 * Example: Employee where EmployeeName = "Sales" must have commision
 */
public class TupleRule implements RuleType {
    private String  entity,
                    column,
                    otherColumn,
                    operator;
    private boolean not;

    public Object makeRuleType(){
        return this;
    }
}
