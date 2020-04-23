package com.pluralflights.mileage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import com.pluralflights.flight.BusinessFlight;
import com.pluralflights.flight.EconomyFlight;
import com.pluralflights.flight.Flight;
import com.pluralflights.flight.PremiumFlight;
import com.pluralflights.passenger.Passenger;

public class FlightArgumentConverter extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {

		assertEquals(String.class, source.getClass(), "Can only convert from String");
		assertEquals(Flight.class, targetType, "Can only convert to flight");

		String[] flightStrings = source.toString().split(";");

		Flight flight = null;

		switch (flightStrings[1].toLowerCase().trim()) {
		case "e":
			flight = new EconomyFlight(flightStrings[0]);
			break;
		case "b":
			flight = new BusinessFlight(flightStrings[0]);
			break;
		case "p":
			flight = new PremiumFlight(flightStrings[0]);
		}
		
		flight.addPassenger(new Passenger(flightStrings[2].trim(), Boolean.valueOf(flightStrings[3].trim())));
		flight.setDistance(Integer.valueOf(flightStrings[4].trim()));

		return flight;
	}

}
