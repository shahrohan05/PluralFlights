package com.pluralflights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {

	private String id;
	protected List<Passenger> passengersList = new ArrayList<Passenger>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public List<Passenger> getPassengersList() {
		return Collections.unmodifiableList(passengersList);
	}	

	/*
	 * Only VIP passengers can be added to business class.
	 * */
	public abstract boolean addPassenger(Passenger passenger);

	
	/*
	 * A VIP passenger cannot be removed from a flight 
	 * */
	public abstract boolean removePassenger(Passenger passenger);

}
