package RuleType;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeRule implements RuleType {
    private String  entity,
                    operator,
                    value;

    public Object makeRuleType() {
        return this;
    }
}

