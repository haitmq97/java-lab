package com.example.springdemo.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.entity.Customer;
import org.hibernate.query.Query;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//define Session factory with autowiring
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get session from session factory
		Session session = sessionFactory.getCurrentSession();
		
		// create query to get customers list
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute the query and return customer list 
		
		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}
	
	
	
	

}
