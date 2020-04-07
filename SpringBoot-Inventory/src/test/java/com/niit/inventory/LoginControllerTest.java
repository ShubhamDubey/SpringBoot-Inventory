package com.niit.inventory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;

import com.niit.inventory.controller.LoginController;
import com.niit.inventory.model.Address;
import com.niit.inventory.model.Dealer;
import com.niit.inventory.service.LoginService;

public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	private LoginService lservice;

	@Spy
	Model model;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void viewRegisterPageTest() {
		Assert.assertEquals(loginController.viewRegisterPage(model), "registration");
	}

	@Test
	public void createDealerTest() {
		Dealer d = new Dealer();
		d.setId(1L);
		d.setFname("Deepanshu");
		d.setEmail("xyz@gmail.com");
		d.setLname("Gupta");
		d.setPassword("root");
		d.setDob(java.sql.Date.valueOf("1996-09-20"));
		d.setPhoneNo("9654346513");

		Address a = new Address();
		a.setStreet("Tri Nagar");
		a.setCity("New Delhi");
		a.setPincode(110035);

		d.setAddress(a);
		a.setDealer(d);

		lservice.saveDealer(d);
		verify(lservice, times(1)).saveDealer(d);
	}

	@Test
	public void loginDealerTest() {
		Assert.assertEquals(loginController.showLoginForm(model), "login");
	}

	@Test
	public void loginDealer() {

		String email = "xyz@gmail.com";
		String password = "root";
		Dealer d=lservice.findByEmail(email);
		assertEquals(d,verify(lservice, times(1)).findByEmail(email));

	}

}