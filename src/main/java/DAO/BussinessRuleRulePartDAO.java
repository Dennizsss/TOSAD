package DAO;

import java.sql.Connection;

/**
 * Created by Arthur on 19-1-2017.
 */
public class BussinessRuleRulePartDAO {

    private DatabaseConnection db;
    private Connection con;

    public BussinessRuleRulePartDAO() {
        this.db = new DatabaseConnection();
        this.con = db.getCon();
    }


}
