package com.infinitelambda.primenumber.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about next prime number found")
public class NextPrimeNumberResult {
	
	@ApiModelProperty(notes = "Next prime number value")
	private int nextPrime;
	
	@ApiModelProperty(notes = "Error flag - true if error, false otherwise")
	private boolean error;
	
	@ApiModelProperty(notes = "Error message value")
	private String message;
	
	public NextPrimeNumberResult() {
		super();
		this.error = false;
		this.message = "";
		this.nextPrime = -1;
	}

	public int getNextPrime() {
		return nextPrime;
	}

	public void setNextPrime(int nextPrime) {
		this.nextPrime = nextPrime;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
