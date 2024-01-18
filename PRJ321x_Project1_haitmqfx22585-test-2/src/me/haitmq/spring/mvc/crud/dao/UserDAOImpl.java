package me.haitmq.spring.mvc.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;

import me.haitmq.spring.mvc.crud.entity.Role;
import me.haitmq.spring.mvc.crud.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate template;

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
	public List<User> getUsersByPage(int pageid, int total) {

		String theQuery = "select * from user limit "+(pageid-1)+", " + total;
		
		return template.query(theQuery, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				
				return user;
			}
		});
	}
	
	

}
