package Model;

import RuleType.RuleType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Wik on 08/01/2017.
 */
@Entity
@Table(name = "RulePart")
public class RulePart {
    private int Id;
    private String name;
    private String table;
    private String query;
    private int order;
    private String condition;
    private ArrayList<RuleType> types = new ArrayList();

    public RulePart() {
    }

    public RulePart(int id, String name, String query, String table) {
        this(id, name, table, query, 0, null, null);
    }

    public RulePart(int id, String name, ArrayList<RuleType> types) {
        this(id, name, null, null, 0, null, types);
    }

    public RulePart(int id ,String name, String table, String query, int order, String condition) {
        this(id, name, table, query, order, condition, null);
    }

    public RulePart(String name, String table, String query, int order, String condition) {
        this(0, name, table, query, order, condition, null);
    }

    public RulePart(int id ,String name, String table, String query, int order, String condition, ArrayList<RuleType> types) {
        this.Id = id;
        this.name = name;
        this.query = query;
        this.order = order;
        this.condition = condition;
        this.table = table;
        this.types = types;
    }

    public Object getRuleTypes() {return types;}

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }

    public String toString() {
        if (!this.condition.matches("NULL")) {
            return this.query + " " + this.condition;
        } else {
            return this.query;
        }
    }
}
