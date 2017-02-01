package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Arthur on 19-1-2017.
 */
public class TargetDatabaseConnection {

    private static SessionFactory factory;

    public TargetDatabaseConnection() {
        int tries = 0;

        if (this.getFactory() != null) {
            while (this.isClosed()) {
                if (tries == 5) break;
                this.openConnection();
                tries++;
            }
        } else {
            this.openConnection();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        TargetDatabaseConnection.factory = factory;
    }

    public boolean isClosed() {
        try {
            if (this.getFactory().isClosed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void openConnection() {
        try{
            setFactory(new Configuration().configure("target.cfg.xml").buildSessionFactory());
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
