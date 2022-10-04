package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {

	// Inside class:    
	private ArrayList<String> patientNotes;    
	
	// TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		
	}

    
    // TO DO: Implement HIPAACompliantUser!
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    //Pin must be 6 digits or more; returns false if not
    // assign the pin to the user (as a member variable)
	@Override
	public boolean assignPin(int pin) {
		if(pin < 1000 || pin >9999) {
			return false;
		}
		this.pin = pin;
		return true;
	}

//	Compares the ids, and if they are not a match,
//	creates an incident report using the  authIncident method,
//	Returns true if ids match, false if not.
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID != this.id) {
			return false;
		}
		return true;
	}
	
	//TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	

}
