package me.haitmq.spring.mvc.crud.service;

import java.util.List;

import me.haitmq.spring.mvc.crud.entity.Donation;

public interface DonationService {
	
	public void save(Donation donation);
	
	public Donation getDonation(int theId);
	
	public List<Donation> getDonationList();

}
