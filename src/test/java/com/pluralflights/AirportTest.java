package com.pluralflights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AirportTest {

	@Test
	public void testAirport() {
		System.out.println("executing tests now!");
		
		Flight economyFlight = new Flight("1", "Economy");
		Flight businessFlight = new Flight("1", "Business");
		
		Passenger john = new Passenger("John", true);
		Passenger mike = new Passenger("Mike", false);
		
		// John being a VIP passenger can be added to both the types of flights
		assertEquals(true, economyFlight.addPassenger(john));
		assertEquals(true, businessFlight.addPassenger(john));
		
		// John being a VIP passenger cannot be removed from either type of flight
		assertEquals(false, economyFlight.removePassenger(john));
		assertEquals(false, businessFlight.removePassenger(john));
		
		// Mike being a non-VIP passenger cannot be added to business flight
		assertTrue(economyFlight.addPassenger(mike));
		assertFalse(businessFlight.addPassenger(mike));
		
		// Mike can only be removed from economy flight
		assertTrue(economyFlight.removePassenger(mike));
		assertFalse(businessFlight.removePassenger(mike));
	}
}
