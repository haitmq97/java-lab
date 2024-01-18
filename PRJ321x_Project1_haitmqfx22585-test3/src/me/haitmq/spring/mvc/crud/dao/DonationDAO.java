package me.haitmq.spring.mvc.crud.dao;

import java.util.List;

import me.haitmq.spring.mvc.crud.entity.Donation;

public interface DonationDAO {
	
	public void save(Donation donation);
	
	public Donation getDontaion(int theId);
	
	public List<Donation> getDonationList();

}
