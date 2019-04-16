package com.tiedros.microservices.limitsservice.beans;

public class limitConfiguration {
	private int minimum;
	private int maximum;
	
	
	
	public limitConfiguration() {
		super();
	}



	public limitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}



	public int getMinimum() {
		return minimum;
	}



	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}



	public int getMaximum() {
		return maximum;
	}



	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}



	@Override
	public String toString() {
		return "limitConfiguration [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
	
}
