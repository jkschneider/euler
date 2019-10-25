package com.euler.p69;

import static com.euler.MathExt.gcd;
import static com.euler.util.PrimeTest.prime;

import java.util.HashMap;
import java.util.Map;

class Problem69 {
	int N = 1000000;
	
	Map<Integer, Integer> totientCache = new HashMap<Integer, Integer>();
	
	int totient(int n) {
		if(n == 1 || n == 2) return 1;
		Integer totient = totientCache.get(n);
		
		if(totient == null) {
			if(n % 2 == 0) {
				if(n/2 % 2 == 0)
					totient = 2*totient(n/2);
				else
					totient = totient(n/2);
			}
			else if(prime(n))
				totient = n-1;
			else {
				// phi(i*j) = phi(i)*phi(j)*(d/phi(d)) where d = gcd(i,j)
				int i = firstFactor(n);
				int j = n/i;
				int d = (int) gcd(i,j);
				totient = (totient(i)*totient(j)*d)/totient(d);
			}
			
			totientCache.put(n, totient);
		}
		return totient;
	}
	
	int firstFactor(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++)
			if(n % i == 0)
				return i;
		return n;
	}

	void run() {
		int maxN = 0;
		double max = 0;
		
		for(int n = 1; n <= N; n++) {
			double totN = totient(n);
			if(n/totN > max) {
				max = n/totN;
				maxN = n;
			}
		}
		
		System.out.println("solution = " + maxN);
	}
	
	public static void main(String[] args) {
		new Problem69().run();
	}
}