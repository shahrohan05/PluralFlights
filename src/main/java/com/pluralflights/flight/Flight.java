package com.pluralflights.flight;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.pluralflights.passenger.Passenger;

public abstract class Flight {

	private String id;
	private int distance;
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
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	

	/*
	 * Only VIP passengers can be added to business class.
	 * New Feature : Allow VIP in premium flight
	 * Enhancement 1 : A passenger can only be added once to a flight
	 * */
	public abstract boolean addPassenger(Passenger passenger);

	
	/*
	 * A VIP passenger cannot be removed from a flight
	 *  New Feature : VIP can be removed from premium flight
	 *  Enhancement 1 : A passenger can only be added once to a flight
	 * */
	public abstract boolean removePassenger(Passenger passenger);



}
