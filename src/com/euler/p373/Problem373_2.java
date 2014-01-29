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

		int N = 1200;
		for(long a = 1; a <= 2*N; a++) {
			for(long b = (int) ceil((((double) a)+1)/2); b <= a; b++) {
				for(long c = a+1-b; c <= b; c++) {
					double r = (a*b*c) / sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c));
					if(floor(r) == r) {
						if(r <= N && r > 0) {
//							System.out.println(a + ", " + b + ", " + c + " = " + r);
//							System.out.println("\t\tgcd(a,b,c) = " + gcd(a,b,c));
							sum += r;
						}
					}
				}
			}
		}
		
		System.out.println("sum = " + sum);
	}
	
	int gcd(long a, long b, long c) {
		return (int) MathExt.gcd(MathExt.gcd(a,b), MathExt.gcd(b,c));
	}
	
	boolean relativelyPrime(int m, int n, int k) {
		return MathExt.gcd(m,n) == 1 && MathExt.gcd(n,k) == 1 && MathExt.gcd(m,k) == 1;
	}
}
