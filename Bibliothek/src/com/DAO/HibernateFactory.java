package com.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	
	private static SessionFactory sessionFactory;
	
	/**
	 * Builds a new SessionFactory Singleton
	 * @return
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory() throws HibernateException {
		if(sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}
	
	/**
	 * Builds a new SessionFactory Singleton if there is none
	 * @return
	 * @throws HibernateException
	 */
	public static SessionFactory buildIfNeeded() throws HibernateException{
		if(sessionFactory != null ) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		}catch(HibernateException e) {
			throw new HibernateException(e);
		}
	}
	
	/**
	 * Creates a sessionFactory if needed, and opens a new session
	 * @return
	 * @throws HibernateException
	 */
	public static Session openSession() throws HibernateException {
		buildIfNeeded();
		return sessionFactory.openSession();
	}
	
	/**
	 * Closes sessionFactory
	 */
	public static void closeFactory() {
		if(sessionFactory != null) {
			try {
				sessionFactory.close();
			}catch(HibernateException ignored) {
				System.out.println("[HibernateFactory: closeFactory()] - Couldn't close sessionFactory : " + ignored);
			}
		}
	}
	
	/**
	 * Closes session
	 * @param session
	 */
	public static void close(Session session) {
		if(session != null) {
			try {
				session.close();
			}catch(HibernateException ignored) {
				System.out.println("[HibernateFactory: close()] - Couldn't close session : " + ignored);
			}
		}
	}
	
	/**
	 * Rollback transaction
	 * @param transaction
	 */
	public static void rollback(Transaction transaction) {
		try {
			if(transaction != null) {
				transaction.rollback();
			}
		}catch(HibernateException e) {
			System.out.println("[HibernateFactory: rollback()] - Couldn't rollback transaction : " + e);
		}
	}
	
	/**
	 * Configures the SessionFactory
	 * @return
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory() throws HibernateException {
		Configuration config = new Configuration();
		config.configure("/resources/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
		return sessionFactory;
	}
	
	/**
	 * SessionFactory's Getter
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
