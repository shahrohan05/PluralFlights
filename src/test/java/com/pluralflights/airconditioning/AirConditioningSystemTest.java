package com.pluralflights.airconditioning;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AirConditioningSystemTest {
	
	@InjectMocks
	AirConditioningSystem airConditioningSystem;
	
	@Mock
	Thermometer thermometer;

	@DisplayName("Verify that the air conditioning system starts when temperature is above threshold")
	@Test
	void testAirConditioningSystemStarted() {
		
		Mockito.when(thermometer.getTemperature()).thenReturn(25.0); // set thermometer mock to return 25.0 when temperature requested.
		
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		
		assertTrue(airConditioningSystem.isOpen());
		
		Mockito.verify(thermometer, Mockito.times(1)).getTemperature(); // verify that the getTemperature was called on the mock atleast once.
		
	}
	
	@DisplayName("Verify that the air conditioning system stops when temperature is below threshold")
	@Test
	void testAirConditioningSystemStopped() {
		
		Mockito.when(thermometer.getTemperature()).thenReturn(23.0); // set thermometer mock to return 23.0 when temperature requested.
		
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		
		assertFalse(airConditioningSystem.isOpen());
		
		Mockito.verify(thermometer, Mockito.times(1)).getTemperature();
		
	}

}
