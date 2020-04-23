package com.pluralflights.airconditioning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ThermometerTest {

	@InjectMocks
	Thermometer thermometer;

	@Mock
	Sensor sensor;

	@DisplayName("Verify that Thermometer returns the temperature as expected when the sensor is not blocked")
	@Test
	void testWorkingSensor() {
		thermometer.setTemperature(25.0);

		Mockito.when(sensor.isBlocked()).thenReturn(false); // set the behavior of the sensor to be unblocked

		assertEquals(sensor, thermometer.getSensor()); // make sure the sensor has been injected into the thermometer.
		
		assertEquals(25.0, thermometer.getTemperature(), 0.001);

		Mockito.verify(sensor, Mockito.times(1)).isBlocked(); // verify that the isBlocked method is invoked only once
																// on the mock "sensor".
	}

	@DisplayName("Verify that Thermometer throws RuntimeException when the sensor blocked and we try to access the temperature")
	@Test
	void testBlockedSensor() {
		thermometer.setTemperature(25);
		Mockito.when(sensor.isBlocked()).thenReturn(true); // sets mock(sensor) to return true, when isBlocked() method
															// is called on it. i.e. Sets the behavior of the sensor to
															// be blocked.
		assertEquals(sensor, thermometer.getSensor());
		
		assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
		
		Mockito.verify(sensor, Mockito.times(1)).isBlocked();
		
		
	}

}
