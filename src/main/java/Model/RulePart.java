package Model;

import RuleType.RuleType;

import java.util.ArrayList;

/**
 * Created by Wik on 08/01/2017.
 */
public class RulePart {
    private int Id;
    private String name;
    private String error;
    private ArrayList<RuleType> types = new ArrayList();

    public RulePart() {
    }

    public RulePart(int id, String name, String error, ArrayList<RuleType> types) {
        Id = id;
        this.name = name;
        this.error = error;
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
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
