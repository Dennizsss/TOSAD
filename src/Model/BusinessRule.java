package Model;

import java.util.ArrayList;

/**
 * Created by Wik on 06/01/2017.
 */
public class BusinessRule {
    private int Id;
    private String Name;
    private String Description;
    private int Status;
    private ArrayList<RulePart> ruleParts = new ArrayList<>();


    public BusinessRule() {
    }

    public BusinessRule(int Id, String name, String description, int status) {
        Id = Id;
        Name = name;
        Description = description;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }


}
