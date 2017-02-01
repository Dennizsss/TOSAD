package RuleType;

import java.util.List;

/**Restriction on a attribute inside object / entity
 * Shape: Entity - Operator - customValue
 * Example: Salary > 50.000
 */
public class AttributeListRule implements RuleType {
    private String  entity,
            column,
            operator;
    private List<String> list;
    private boolean not;

    public Object makeRuleType() {
        return this;
    }
}

