package com.infinitelambda.primenumber.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.infinitelambda.primenumber.domain.NextPrimeNumberResult;
import com.infinitelambda.primenumber.domain.PrimeNumberCheckResult;
import com.infinitelambda.primenumber.service.PrimeNumberService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PrimeNumberController.class)
public class PrimeNumberControllerTest {

	@MockBean
	private PrimeNumberService primeNumberService;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testValidPrimeNumber() throws Exception {
		PrimeNumberCheckResult checkResult = new PrimeNumberCheckResult();
		checkResult.setPrimeNumber(true);
		BDDMockito.given(primeNumberService.isPrimeNumber(17)).willReturn(checkResult);
		this.mockMvc.perform(get("/api/primenumber/check?query=17"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"primeNumber\":true")));
	}
	
	@Test
	public void testNotPrimeNumber() throws Exception {
		PrimeNumberCheckResult checkResult = new PrimeNumberCheckResult();
		checkResult.setPrimeNumber(false);
		BDDMockito.given(primeNumberService.isPrimeNumber(15)).willReturn(checkResult);
		this.mockMvc.perform(get("/api/primenumber/check?query=15"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"primeNumber\":false")));
	}
	
	@Test
	public void testNextPrimeNumber() throws Exception {
		NextPrimeNumberResult nextPrimeNumberResult = new NextPrimeNumberResult();
		nextPrimeNumberResult.setNextPrime(7);
		BDDMockito.given(primeNumberService.findNextPrime(5)).willReturn(nextPrimeNumberResult);
		this.mockMvc.perform(get("/api/primenumber/next?query=5"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"nextPrime\":7")));
	}
}
