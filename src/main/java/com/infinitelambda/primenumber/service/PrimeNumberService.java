package com.infinitelambda.primenumber.service;

import org.springframework.stereotype.Service;
import com.infinitelambda.primenumber.domain.NextPrimeNumberResult;
import com.infinitelambda.primenumber.domain.PrimeNumberCheckResult;

@Service
public class PrimeNumberService {

	/**
	 * checks if specified value is prime number, i.e. 2, 3, 5 etc.
	 * @param value integer value to be checked
	 * @return boolean true if prime number, otherwise false
	 */
	public boolean isPrimeNumberInternal(int value) {
		boolean isPrimeNumber = false;
		if (value <= 1) {
			return isPrimeNumber;
		}
		isPrimeNumber = true;
		if (value <= 3) {
			return isPrimeNumber;
		}

		int counter = 2;
		do {
			if (value % counter == 0) {
				isPrimeNumber = false;
			}
			counter += 1;
		} while (counter <= value/2 && isPrimeNumber);
		
		return isPrimeNumber;
	}
	
	public PrimeNumberCheckResult isPrimeNumber(int value) {
		PrimeNumberCheckResult primeNumberCheckResult = new PrimeNumberCheckResult();
		try {
			primeNumberCheckResult.setPrimeNumber(isPrimeNumberInternal(value));
		} catch (Exception e) {
			primeNumberCheckResult.setError(true);
			primeNumberCheckResult.setMessage(e.getMessage());
		}
		
		return primeNumberCheckResult;
	}
	
	/**
	 * finds the next smallest prime number after the specified one
	 * @param value integer to look after
	 * @return next smallest prime number after the specified one
	 */
	private int findNexтPrimeInternal(int value) {
		if (value <= 1) {
			return 2;
		}
		boolean isPrime = false;
		int nextPrime = value;
		while (!isPrime) {
			nextPrime += 1;
			isPrime = isPrimeNumberInternal(nextPrime);
		}
		
		return nextPrime;
	}
	
	public NextPrimeNumberResult findNextPrime(int value) {
		NextPrimeNumberResult nextPrimeNumberResult = new NextPrimeNumberResult();
		try {
			nextPrimeNumberResult.setNextPrime(findNexтPrimeInternal(value));
		} catch (Exception e) {
			nextPrimeNumberResult.setError(true);
			nextPrimeNumberResult.setMessage(e.getMessage());
		}
		
		return nextPrimeNumberResult;
	}
}
