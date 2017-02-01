package Test;

import DAO.ResourceDatabaseConnection;
import DAO.TargetDatabaseConnection;
import Model.RulePart;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import org.hibernate.sql.ordering.antlr.Factory;

import java.io.Console;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arthur on 26-1-2017.
 */
public class Main {
	private static SessionFactory factory;
	private static SessionFactory factory2;

	public static void main(String[] args) {
		TargetDatabaseConnection tdc = new TargetDatabaseConnection();
		factory = tdc.getFactory();

		//ResourceDatabaseConnection rdc = new ResourceDatabaseConnection();
		//factory2 = rdc.getFactory();


		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		try {
			SessionFactoryImplementor sfi = (SessionFactoryImplementor)factory;
			String name = sfi.getSettings().getDefaultSchemaName();

			System.out.println(name);

			//SQLQuery queryg = session.createSQLQuery("ALTER SESSION SET CURRENT_SCHEMA=TOSAD_2016_2D_TEAM3_TARGET");
			//queryg.executeUpdate();

			//SQLQuery query = session.createSQLQuery("select ID from VBMG_KLANTEN");
			SQLQuery query = session.createSQLQuery("select ID, NAME from BUSINESSRULE");
			List<Object[]> rows = query.list();
			for(Object[] row : rows){
				System.out.println(row[0].toString());
				System.out.println(row[1].toString());
				System.out.println(row[2].toString());
			}
			tx = null;
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
