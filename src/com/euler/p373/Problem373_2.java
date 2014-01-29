package com.euler.p373;

import static com.euler.MathExt.*;

public class Problem373_2 {
	public static void main(String[] args) {
		new Problem373_2().run();
	}

	public void run() {
		int N = 25;
		
		for(int k = 1; k < N; k++) {
			for(int n = 1; n < N; n++) {
				for(int m = n; m < N; m++) {
					if(relativelyPrime(m,n,k) && m*n > k*k && k*k > (m*m*n)/(2*m+n)) {
						int a = n*(m*m+(k*k));
						int b = m*(n*n+(k*k));
						int c = (m+n)*(m*n-(k*k));
						
						System.out.println(a + ", " + b + ", " + c);
					}
				}
			}
		}
	}
	
	boolean relativelyPrime(int m, int n, int k) {
		return gcd(m,n) == 1 && gcd(n,k) == 1 && gcd(m,k) == 1;
	}
}
