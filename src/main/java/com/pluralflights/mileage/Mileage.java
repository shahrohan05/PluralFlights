package com.pluralflights.mileage;

import java.util.HashMap;
import java.util.Map;

import com.pluralflights.passenger.Passenger;

public class Mileage {
	
	public static final int VIP_FACTOR = 10;
	public static final int USUAL_FACTOR = 20;
	
	private Map<Passenger, Integer> passengerMileageMap = new HashMap<>();
	private Map<Passenger, Integer> passengerPointsMap = new HashMap<>();
	
	
	public void addMileage(Passenger passenger, int distance) {
		if(passengerMileageMap.containsKey(passenger)) {
			passengerMileageMap.put(passenger, passengerMileageMap.get(passenger).intValue() + distance);
		}else {
			passengerMileageMap.put(passenger, distance);
		}
	}


	public void calculatePoints() {
		for(Passenger p : passengerMileageMap.keySet()) {
			passengerPointsMap.put(p, passengerMileageMap.get(p).intValue() / (p.isVip() ? VIP_FACTOR : USUAL_FACTOR));
		}
	}


	public Map<Passenger, Integer> getPassengerPointsMap() {
		return passengerPointsMap;
	}


	
	

}
