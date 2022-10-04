package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	// Inside class:
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}
	
	public void newIncident(String notes) {
		String report = String.format(
		"Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
		new Date(), this.id, notes
		);
		securityIncidents.add(report);
	}
	public void authIncident() {
		String report = String.format(
		"Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
		new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
		);
		securityIncidents.add(report);
	}
	
	// TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		if(pin < 100000) {
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	// TO DO: Implement HIPAACompliantAdmin!
	@Override
	public void printSecurityIncidents() {
		// TODO Auto-generated method stub
		HIPAACompliantAdmin.super.printSecurityIncidents();
	}
	
	@Override
	public boolean adminQATest(ArrayList<String> expectedIncidents) {
		// TODO Auto-generated method stub
		return HIPAACompliantAdmin.super.adminQATest(expectedIncidents);
	}
	
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(confirmedAuthID != this.id) {
			authIncident();
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}
	
	//SETTERS AND GETTERS
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
	
	
	
	
	
	
	
	
}
