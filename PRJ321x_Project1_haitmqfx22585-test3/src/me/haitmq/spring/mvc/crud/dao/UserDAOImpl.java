package me.haitmq.spring.mvc.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.haitmq.spring.mvc.crud.entity.Role;
import me.haitmq.spring.mvc.crud.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(User user) {
		Session session = getSession();
		Role role = user.getRole();
		session.save(role);
		session.save(user);

	}

	@Override
	public User getUser(int theId) {
		return getSession().get(User.class, theId);
	}

	@Override
	public List<User> getUserList() {
		Query<User> theQuery = getSession().createQuery("from User", User.class);

		// execute the query and return user list

		return theQuery.getResultList();
	}
	
	


	@Override
	public Page<User> findAll(Pageable pageable) {
	    Query<User> theQuery = getSession().createQuery("from User", User.class);
	    theQuery.setFirstResult((int) pageable.getOffset());
	    theQuery.setMaxResults(pageable.getPageSize());

	    return new PageImpl<>(theQuery.getResultList(), pageable, countUsers());
	}

	private long countUsers() {
	    Query<Long> countQuery = getSession().createQuery("select count(u) from User u", Long.class);
	    return countQuery.uniqueResult();
	}

	@Override
	public Iterable<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAllByEmailOrPhoneNumber(Pageable pageable, String searchingValue) {
	    Query<User> theQuery = getSession().createQuery(
	            "from User u where u.email like concat(:searchingValue, '%') or u.phoneNumber like concat(:searchingValue, '%')", User.class);
	    
	    theQuery.setParameter("searchingValue", searchingValue); // Đặt giá trị cho tham số
	    
	    theQuery.setFirstResult((int) pageable.getOffset());
	    theQuery.setMaxResults(pageable.getPageSize());

	    Query<Long> countForSearchQuery = getSession().createQuery(
	            "select count(u) from User u where u.email like concat(:searchingValue, '%') or u.phoneNumber like concat(:searchingValue, '%')", Long.class);

	    countForSearchQuery.setParameter("searchingValue", searchingValue); // Đặt giá trị cho tham số

	    return new PageImpl<>(theQuery.getResultList(), pageable, countForSearchQuery.uniqueResult());
	}
	
	
	//@Query("SELECT e FROM YourEntity e WHERE e.email LIKE %:search% OR e.phoneNumber LIKE %:search%")
	

	
	

}
