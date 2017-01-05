package RuleType;

public class AttributeRangeRule implements RuleTypeStrategy {
    private String lhs, rhs, constraint, operator;
    public AttributeRangeRule(String lhs, String rhs, String operator) {
    }

    public AttributeRangeRule(String constraint) {
    }
}

