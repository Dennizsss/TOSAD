package Model;

/**
 * Created by Wik on 06/01/2017.
 */
public class BusinessRule {
    private int Br_Id;
    private String Name;
    private String Description;
    private int Status;


    public BusinessRule() {
    }

    public BusinessRule(int br_Id, String name, String description, int status) {
        Br_Id = br_Id;
        Name = name;
        Description = description;
        Status = status;
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


}
