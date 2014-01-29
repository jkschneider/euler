package com.euler.p373;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import com.euler.MathExt;

public class Problem373_2 {
	public static void main(String[] args) {
		new Problem373_2().run();
	}

	public void run() {
		int sum = 0;

		int N = 10000000;
		// for the radius to be an integer, gcd(a,b,c) must be a multiple of 2, therefore, a,b,c must always be even
		for(long a = 2; a <= 2*N; a+=2) {
			if(a % 1000 == 0)
				System.out.println(a);
			for(long b = ceilEven(a); b <= a; b+=2) {
				for(long c = a-b; c <= b; c+=2) {
					double r = (a*b*c) / sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c));
					
					if(floor(r) == r) {
						if(r <= N) {
//							System.out.println(a + "," + b + "," + c + "," + (int) r + "," + gcd(a,b,c) + "," + (b*b + c*c) + "," + (a*a));
							sum += r;
						}
					}
				}
			}
		}
		
		System.out.println("sum = " + sum);
	}
	
	long ceilEven(long a) {
		long ceil = (long) ceil((((double) a)+1)/2);
		if(ceil % 2 != 0) ceil++;
		return ceil;
	}
	
	int gcd(long a, long b, long c) {
		return (int) MathExt.gcd(MathExt.gcd(a,b), MathExt.gcd(b,c));
	}
}
