package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wik on 06/01/2017.
 */
public class BusinessRule {
    private Integer Id;
    private String name;
    private String description;
    private Integer status;
    private String database;
    private ArrayList<RulePart> ruleParts = new ArrayList<RulePart>();

    public BusinessRule() {

    }

    public BusinessRule(Integer Id, String name, String description, Integer status, String database) {
        this(Id, name, description, status, database, null);
    }

    public BusinessRule(Integer Id, String name, String description, Integer status, String database, ArrayList<RulePart> ruleParts) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.database = database;
        this.ruleParts = ruleParts;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public ArrayList<RulePart> getRuleParts() {
        return ruleParts;
    }

    public void setRuleParts(ArrayList<RulePart> ruleParts) {
        this.ruleParts = ruleParts;
    }
}
