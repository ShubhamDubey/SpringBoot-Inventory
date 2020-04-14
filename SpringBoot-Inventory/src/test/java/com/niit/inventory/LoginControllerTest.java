package com.niit.inventory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.niit.inventory.controller.LoginController;
import com.niit.inventory.model.Address;
import com.niit.inventory.model.Dealer;
import com.niit.inventory.service.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { LoginController.class })
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
	public void loginDealerTest1() {
		String email = "satyam1@gmail.com";
		Dealer d = new Dealer();
		d.setEmail("satyam1@gmail.com");
		d.setPassword("12345");
		when(lservice.findByEmail(email)).thenReturn(d);

		Dealer x = lservice.findByEmail("satyam1@gmail.com");

		assertEquals(x.getEmail(), "satyam1@gmail.com");
		assertEquals(x.getPassword(), loginController.encryptPass("12345"));
		verify(lservice, times(1)).findByEmail("satyam1@gmail.com");
	}

	@Spy
	HttpServletRequest request;
	@Spy
	HttpSession ses;

	@Test
	public void logoutTest() {
		when(request.getSession()).thenReturn(ses);
		Assert.assertEquals(loginController.logout(request), "index");
	}

}