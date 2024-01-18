package me.haitmq.spring.mvc.crud.dao;

import java.util.List;

import me.haitmq.spring.mvc.crud.entity.User;

public interface UserDAO {

	// add user
	
	public void save(User user);
	
	public User getUser(int theId);
	
	public List<User> getUserList();
	
	public List<User> getUsersByPage(int pageid, int total);
	
}
