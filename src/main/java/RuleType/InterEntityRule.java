package RuleType;

import Model.RulePart;

/** Puts a restriction on relations from a different entity
 * Shape:  Entity - Column - Operator - Entity - Column
 * Example: SalesLine.Price >= Product.MinimumPrice
 */
public class InterEntityRule implements RuleType {
    private String  firstEntity,
                    secondEntity,
                    firstColumn,
                    secondColumn,
                    operator;
    private boolean not;

    public Object makeRuleType() {
        return null;
    }

    public String generateStatement(RulePart rulePart) {
        return "";
    }
}
