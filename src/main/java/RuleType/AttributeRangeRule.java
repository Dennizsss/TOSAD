package RuleType;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeRangeRule implements RuleType {
    private String  entity,
            column,
            operator,
            valuetype,
            value;
    private boolean not;

    public Object makeRuleType() {
        return this;
    }
}

