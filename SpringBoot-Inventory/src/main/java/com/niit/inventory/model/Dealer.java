package com.niit.inventory.model;



import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Base64;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dealer")
public class Dealer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="password")
	private String password;
	
	
	 @Column(name="dob")
	 private Date dob;
	 
	@Column(name="phone")
	private String phoneNo;
	
	@OneToOne(mappedBy="dealer",cascade =  CascadeType.ALL)
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =  encryptPass(password);
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	private String encryptPass(String pass) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = pass;
		String encodedString = encoder.encodeToString(
	    normalString.getBytes(StandardCharsets.UTF_8) );
		return encodedString;
	}
	
}
