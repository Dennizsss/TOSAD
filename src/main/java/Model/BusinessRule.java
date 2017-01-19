package Model;

import java.util.ArrayList;

/**
 * Created by Wik on 06/01/2017.
 */
public class BusinessRule {
    private int Br_Id;
    private String Name;
    private String Description;
    private int Status;
    private ArrayList<RulePart> ruleParts;


    public BusinessRule() {
    }

    public BusinessRule(String name, String description, int status) {
        this(0, name, description, status, null);
    }

    public BusinessRule(int br_Id, String name, String description, int status) {
        this(br_Id, name, description, status, null);
    }

    public BusinessRule(int br_Id, String name, String description, int status, ArrayList<RulePart> ruleParts) {
        this.Br_Id = br_Id;
        this.Name = name;
        this.Description = description;
        this.Status = status;
        this.ruleParts = ruleParts;
    }

    public int getBr_Id() {
        return Br_Id;
    }

    public void setBr_Id(int br_Id) {
        Br_Id = br_Id;
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

    public ArrayList<RulePart> getRuleParts() {
        return ruleParts;
    }

    public void setRuleParts(ArrayList<RulePart> ruleParts) {
        this.ruleParts = ruleParts;
    }
}
