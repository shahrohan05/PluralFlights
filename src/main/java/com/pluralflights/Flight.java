package com.pluralflights;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Flight {

	private String id;
	protected Set<Passenger> passengersSet = new HashSet<Passenger>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return Collections.unmodifiableSet(passengersSet);
	}	

	/*
	 * Only VIP passengers can be added to business class.
	 * 
	 * New Feature : Allow VIP in premium flight
	 * */
	public abstract boolean addPassenger(Passenger passenger);

	
	/*
	 * A VIP passenger cannot be removed from a flight
	 * 
	 *  New Feature : VIP can be removed from premium flight
	 * */
	public abstract boolean removePassenger(Passenger passenger);

}
