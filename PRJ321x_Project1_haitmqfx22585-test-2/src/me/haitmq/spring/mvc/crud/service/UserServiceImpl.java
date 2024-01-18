package me.haitmq.spring.mvc.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.haitmq.spring.mvc.crud.dao.UserDAO;
import me.haitmq.spring.mvc.crud.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void save(User user) {
		userDAO.save(user);

	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public List<User> getUsersByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		return userDAO.getUsersByPage(pageid, total);
	}
	
	
	
	

}
