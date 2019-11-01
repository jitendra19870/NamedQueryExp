package com.nit.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Department;
import com.nit.util.HibernateUtil;

public class NamedQueryTest {

	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			List<Long> totalDept = session.createNamedQuery("get_total_dept", Long.class).getResultList();
			System.out.println("Total Department: " + totalDept.get(0));
			List<String> deptName = session.createNamedQuery("getdeptnamebyid", String.class).setParameter("id", 2)
					.getResultList();
			for (Object object : deptName) {
				System.out.println(object);
			}
			List<Department> departments = session.createNamedQuery("getalldept", Department.class).getResultList();
			for (Department department : departments) {
				System.out.println("ID : " + department.getId() + " \tNAME : " + department.getName());
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
