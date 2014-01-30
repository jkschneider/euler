package com.euler.p63;

import java.math.BigInteger;

public class Problem63 {
	public static void main(String[] args) {
		int count = 0;
		for(int p = 0; p < 100; p++) {
			for(long n = 1; n <= 250; n++) {
				if(BigInteger.valueOf(n).pow(p).toString().length() == p) {
					count++;
					System.out.println(n + "^" + p);
				}
			}
		}
		
		System.out.println("count = " + count);
	}
}
