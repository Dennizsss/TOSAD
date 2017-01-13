package Model;

/**
 * Created by Wik on 08/01/2017.
 */
public class RulePart {
    private int Id;
    private String Table;
    private String Query;
    private int Order;
    private String Condition;

    public RulePart() {
    }

    public RulePart(int id, String table, String query, int order, String condition) {
        Id = id;
        Table = table;
        Query = query;
        Order = order;
        Condition = condition;
    }

    public int getId() {
        return Id;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }
}
