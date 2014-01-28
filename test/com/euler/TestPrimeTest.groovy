package com.euler;

import org.junit.Test

class TestPrimeTest {
	@Test
	void testPrime() {
		int N = 1000000;
		List<Integer> truePrimes = new ArrayList<Integer>(PrimeGenerator.primeSetLessThan(N));
		Collections.sort(truePrimes);
		
		List<Integer> foundPrimes = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(PrimeTest.prime(BigInteger.valueOf(i)))
				foundPrimes.add(i);
		}
		
		assert foundPrimes == truePrimes;
	}
}