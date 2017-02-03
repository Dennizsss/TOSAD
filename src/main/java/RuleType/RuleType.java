package RuleType;

import Model.RulePart;

public interface RuleType {
    public Object makeRuleType();
    public String generateStatement(RulePart rulePart);
}

