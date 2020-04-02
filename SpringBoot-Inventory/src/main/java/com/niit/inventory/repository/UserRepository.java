package com.niit.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.inventory.model.Dealer;

public interface UserRepository extends JpaRepository<Dealer, Long> {

	public Dealer findByEmail(String email);
}
