package RuleType;

/**Restriction on attributes on more than 2 rows within a entity (table)
 * Shape: Entity - Column - Operator - customValue
 * Example: Employee.employeeNr must be unique
 */
public class EntityRule implements RuleType {
    private String  entity,
                    column,
                    operator,
                    customValue;

    public Object makeRuleType() {
        return null;
    }
}
