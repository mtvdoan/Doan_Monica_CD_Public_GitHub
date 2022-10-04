package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	
	//*These are simply displayed.
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);

}
