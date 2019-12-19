package com.udemy.microservice.limitsservice.bean;

public class LimitsConfiguration {

	int maximum;
	int minimum;

	public LimitsConfiguration() {
		super();
	}

	public LimitsConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}
}
