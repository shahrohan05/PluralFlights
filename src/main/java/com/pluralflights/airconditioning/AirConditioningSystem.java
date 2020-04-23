package com.pluralflights.airconditioning;

/*
 * LOGIC :
 * start the AirConditioningSystem when the temperature is above threshold (open = true)
 * stop the AirConditioningSystem when the temperature is below threshold (open = false)
 * */
public class AirConditioningSystem {
	
	private Thermometer thermometer;
	private double temperatureThreshold;
	private boolean open;
	
	public AirConditioningSystem() {
		this.open = false;
	}
	
	public void checkAirConditioningSystem() {
		this.open = thermometer.getTemperature() >= temperatureThreshold;
	}

	public void setTemperatureThreshold(double temp) {
		this.temperatureThreshold = temp;
	}

	public void setThermometer(Thermometer thermometer) {
		this.thermometer = thermometer;
	}

	public boolean isOpen() {
		return open;
	}

	
	

}
