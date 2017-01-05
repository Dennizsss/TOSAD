package RuleType;

public class AttributeRangeRule implements RuleTypeStrategy {
    private String lhs, rhs, constraint, operator;
    public AttributeRangeRule(String lhs, String rhs, String operator) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = operator;
    }

    public AttributeRangeRule(String constraint) {
        this.constraint = constraint;
    }
}

