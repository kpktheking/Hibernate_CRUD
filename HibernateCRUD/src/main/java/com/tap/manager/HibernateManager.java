package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.Entity.Employee;

public class HibernateManager {
	static Session session=null;
	static{
		session=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
	}
	public void add(Employee e) {
		Transaction t=session.beginTransaction();
		session.persist(e);
		t.commit();
		
	}
	public Employee getUserById(int id) {
		return session.get(Employee.class, id);
	}
	public void delete(int id) {
		session.beginTransaction();
		Employee e=session.get(Employee.class,id);
		if(e!=null) {
			session.delete(e);
			System.out.println("Object Deleted");
		}
		else {
			System.out.println("Object not found");
		}
		session.getTransaction().commit();
	}
	public void updateObject(Employee e) {
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		
	}
	public List<Employee> getAllEmployees(){
		String hql="from Employee";
		Query<Employee> query=session.createQuery(hql);
		return query.list();		
	}
}
