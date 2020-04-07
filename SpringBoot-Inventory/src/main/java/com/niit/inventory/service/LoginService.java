package com.niit.inventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.inventory.model.Dealer;
import com.niit.inventory.repository.DealerRepository;
import com.niit.inventory.repository.UserRepository;

@Service
@Transactional


public class LoginService {
	@Autowired
	private DealerRepository drepo;
	
	@Autowired
	private UserRepository urepo;
	
	public Dealer saveDealer(Dealer dealer) {
		return drepo.save(dealer);
	}
	
	public Dealer findByEmail(String email)
	{
		return urepo.findByEmail(email);
		
	}

	public Dealer findByPassword(String password) {
		// TODO Auto-generated method stub
		return urepo.findByPassword(password);
	}
}
