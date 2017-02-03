package RuleType;

import Model.RulePart;

import java.util.ArrayList;

public interface RuleType {
    public Object makeRuleType();
    public String generateStatement(RulePart rulePart);
    //public ArrayList<String> generateTrigger(RulePart rulePart);
}

