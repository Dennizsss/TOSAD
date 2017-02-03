package RuleType;

import Model.RulePart;

import java.util.ArrayList;

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

//    public ArrayList<String> generateTrigger(RulePart rulePart) {
//        ArrayList<String> parts = new ArrayList<>();
//
//
//        String declare = "cursor cursorID_" + rulePart.getTableName() + " is " +
//                "\nSELECT " + rulePart.getOtherTable() + "." + rulePart.getOtherColumn() +
//                "\nfrom " + rulePart.getOtherTable() + " " +
//                "\nwhere " + rulePart.getOtherTable() + ".id = p_" + rulePart.getTableName() + "_row.new_" + rulePart.getOtherTable() + "_id; " +
//                "\nremoteID_" + rulePart.getColumnName() + "  " + rulePart.getOtherTable() + "." + rulePart.getOtherColumn() + "%type; ";
//
//        String begin = "open cursorID_" + rulePart.getTableName() + " " +
//                "\nfetch cursorID_" + rulePart.getTableName() + " into remoteID_" + rulePart.getColumnName() +
//                "\nclose cursorID_" + rulePart.getTableName() + "; " +
//                "\nl_" + rulePart.getTableName() + " := p_lev_row." + rulePart.getColumnName() + " " + rulePart.getOperator() + " remoteID_" + rulePart.getColumnName() + "; ";
//
//        String ifjes = "if not l_" + rulePart.getTableName() + " then\n" +
//                "\n    raise_application_error (-20800, 3);\n" +
//                "\nend if;";
//
//        parts.add(declare);
//        parts.add(begin);
//        parts.add(ifjes);
//
//        return parts;
//    }
}
