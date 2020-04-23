package com.pluralflights.flight;

import com.pluralflights.passenger.Passenger;

public class EconomyFlight extends Flight {
	

	public EconomyFlight(String id) {
		super(id);
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		return passengersSet.add(passenger);
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		if (!passenger.isVip()) {
			return passengersSet.remove(passenger);
		}
		return false;
	}

}
