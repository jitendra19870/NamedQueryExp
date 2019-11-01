package com.nit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory = null;
	static {
		factory = new Configuration().configure().buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

}
