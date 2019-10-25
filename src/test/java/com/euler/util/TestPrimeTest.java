package com.euler.util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestPrimeTest {
	@Test
	void testPrime() {
		int N = 1000000;
		List<Integer> truePrimes = new ArrayList<>(PrimeGenerator.primeSetLessThan(N));
		Collections.sort(truePrimes);
		
		List<Integer> foundPrimes = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(PrimeTest.prime(BigInteger.valueOf(i)))
				foundPrimes.add(i);
		}
		
		assertThat(foundPrimes).isEqualTo(truePrimes);
	}
}