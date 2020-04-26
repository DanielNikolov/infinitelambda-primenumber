package com.infinitelambda.primenumber.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Prime number validation result")
public class PrimeNumberCheckResult {
	
	@ApiModelProperty(notes = "Error message")
	private String message;
	
	@ApiModelProperty(notes = "Error flag - true if error, false otherwise")
	private boolean error;
	
	@ApiModelProperty(notes = "Flag showing if the value is prime number")
	private boolean primeNumber;
	
	public PrimeNumberCheckResult() {
		super();
		this.error = false;
		this.primeNumber = false;
		this.message = "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isPrimeNumber() {
		return primeNumber;
	}

	public void setPrimeNumber(boolean primeNumber) {
		this.primeNumber = primeNumber;
	}

}
