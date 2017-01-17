package RuleType;

public class AttributeRule implements RuleTypeStrategy {
    private String entity, operator, value;
    
    public AttributeRule(String entity, String value, String operator) {
        this.entity = firstEntity;
        this.operator = operator;
        this.value = customValue;
    }

    /**Restriction on a attribute inside object / entity
     * Shape: Entity - Operator - customValue
     * Example: Salary > 50.000
     */
}

