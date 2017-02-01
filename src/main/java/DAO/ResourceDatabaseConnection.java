package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Arthur on 19-1-2017.
 */
public class ResourceDatabaseConnection {

    private static SessionFactory factory;

    public ResourceDatabaseConnection() {
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

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        ResourceDatabaseConnection.factory = factory;
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
            setFactory(new Configuration().configure("resource.cfg.xml").buildSessionFactory());
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
