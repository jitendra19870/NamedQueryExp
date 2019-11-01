package com.nit.test;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.nit.util.HibernateUtil;

public class ProcedureCallUsingNamedQuery {
	public static void main(String[] args) {
		try {
			Session session =HibernateUtil.getSessionFactory().openSession();
			
			StoredProcedureQuery procQuery=session.createStoredProcedureQuery("count_employee");
			procQuery.registerStoredProcedureParameter("eId", Integer.class, ParameterMode.IN);
			procQuery.registerStoredProcedureParameter("empCount", Integer.class, ParameterMode.OUT);
			procQuery.setParameter("eId", 1);
			Integer empCount=(Integer)procQuery.getOutputParameterValue("empCount");
			System.out.println("emp count:"+empCount);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
