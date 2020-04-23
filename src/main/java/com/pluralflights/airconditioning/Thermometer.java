package com.pluralflights.airconditioning;

/*
 * LOGIC : 
 * Returns temperature only when sensor is not blocked, else throws runtime exception
 * 
 * */
public class Thermometer {
	
	private double temperature;
	private Sensor sensor;
	
	public double getTemperature() {
		if(sensor.isBlocked()) {
			throw new RuntimeException("Sensor is blocked!");
		}
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	

}
