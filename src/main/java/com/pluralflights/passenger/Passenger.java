package com.pluralflights.passenger;

import java.util.Objects;

public class Passenger {

	private String name;
	private boolean vip;

	public Passenger(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		Passenger p = (Passenger) obj;
		return Objects.equals(name, p.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
