package com.gradgateways.neu.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mrunalipawar
 * class : ConnectionDAO
 */
public class ConnectionDAO {

	private static final ThreadLocal sessionThread = new ThreadLocal();
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	protected ConnectionDAO() {
	}

	public static Session getActiveSession() {
		Session session = (Session) ConnectionDAO.sessionThread.get();

		if (session == null) {
			session = sessionFactory.openSession();
			ConnectionDAO.sessionThread.set(session);
		}
		return session;
	}

	protected void beginHibernateTransaction() {
		getActiveSession().beginTransaction();
	}

	protected void commitTransaction() {
		getActiveSession().getTransaction().commit();
	}

	protected void rollbackTransaction() {
		try {
			getActiveSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("WARNING" + "Can not roll back" + e);
		}
		try {
			getActiveSession().close();
		} catch (HibernateException e) {
			System.out.println("WARNING" + "Can not Close the session" + e);
		}
		ConnectionDAO.sessionThread.set(null);
	}

	public static void closeTransaction() {
		getActiveSession().close();
		ConnectionDAO.sessionThread.set(null);
	}
}
