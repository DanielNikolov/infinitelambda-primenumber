package com.infinitelambda.primenumber.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infinitelambda.primenumber.domain.PrimeNumberCheckResult;
import com.infinitelambda.primenumber.domain.NextPrimeNumberResult;
import com.infinitelambda.primenumber.service.PrimeNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/api/primenumber")
@Api(value = "Prime Number Test Tool", description = "Operations for check and generation of next prime number")
public class PrimeNumberController implements ErrorController {
	
	@Autowired
	private PrimeNumberService primeNumberService;

	@GetMapping("/api/primenumber/check")
	@ApiOperation(value = "Verify if number is prime", response = PrimeNumberCheckResult.class)
	public PrimeNumberCheckResult isPrimeNumber(@RequestParam(name = "query", required = true) Integer query) {
		PrimeNumberCheckResult checkResult = primeNumberService.isPrimeNumber(query);

		return checkResult;
	}
	
	@GetMapping("/api/primenumber/next")
	@ApiOperation(value = "Finds next minimal prime number", response = NextPrimeNumberResult.class)
	public NextPrimeNumberResult nextPrimeNumber(@RequestParam(name = "query", required = true) Integer query) {
		NextPrimeNumberResult nextPrimeNumberResult = primeNumberService.findNextPrime(query);
		
		return nextPrimeNumberResult;
	}

	
	@GetMapping("/error")
	public PrimeNumberCheckResult handleError() {
		PrimeNumberCheckResult primeNumberCheckResult = new PrimeNumberCheckResult();
		primeNumberCheckResult.setError(true);
		primeNumberCheckResult.setMessage("Missing or Invalid parameter");
		
		return primeNumberCheckResult;
	}


	@Override
	public String getErrorPath() {
		return "/error";
	}
}
