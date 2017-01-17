package RuleType;

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

    public Object makeRuleType() {
        return null;
    }


}
