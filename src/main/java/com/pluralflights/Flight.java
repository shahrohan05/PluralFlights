package com.pluralflights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {

	private String id;
	private List<Passenger> passengersList = new ArrayList<Passenger>();
	private String flightType;

	public Flight(String id, String flightType) {
		this.id = id;
		this.flightType = flightType;
	}

	public String getId() {
		return id;
	}

	public List<Passenger> getPassengersList() {
		return Collections.unmodifiableList(passengersList);
	}

	public String getFlightType() {
		return flightType;
	}

	public boolean addPassenger(Passenger passenger) {
		switch (flightType) {
			case "Economy":
				return passengersList.add(passenger);
			case "Business":
				if (passenger.isVip()) {
					return passengersList.add(passenger);
				}
				return false;
			default:
				throw new RuntimeException("Unknown type: " + flightType);
		}

	}

	public boolean removePassenger(Passenger passenger) {
		switch (flightType) {
			case "Economy":
				if (passenger.isVip()) {
					return passengersList.remove(passenger);
				}
				return false;
			case "Business":
				return false;
			default:
				throw new RuntimeException("Unknown type: " + flightType);
			}
	}

}
