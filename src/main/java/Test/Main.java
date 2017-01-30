package Test;

import Model.RulePart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by arthur on 26-1-2017.
 */
public class Main {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try{
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}


		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM RulePart");
			List ruleParts = query.list();
			for (Iterator iterator =
				 ruleParts.iterator(); iterator.hasNext(); ) {
				RulePart rulePart = (RulePart) iterator.next();
				System.out.print(" Name: " + rulePart.getName());
				System.out.print("  Query: " + rulePart.getQuery());
				System.out.println("  Table: " + rulePart.getTable());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
