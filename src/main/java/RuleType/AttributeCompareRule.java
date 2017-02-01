package RuleType;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeCompareRule implements RuleType {
    private String  entity,
            column,
            operator;
    private double min, max;
    private boolean not;

    public Object makeRuleType() {
        return this;
    }
}

