package com.euler.p57;

import java.math.BigInteger;

public class Problem57 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		BigInteger prevNum = new BigInteger("1");
		BigInteger prevDenom = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		
		long count = 0;
		
		for(long i = 1; i < 1000; i++) {
			BigInteger num = prevDenom;
			BigInteger denom = prevDenom.multiply(two).add(prevNum);
			
			prevNum = num;
			prevDenom = denom;
			
			if(num.add(denom).toString().length() > denom.toString().length())
				count++;
		}
		
		System.out.println(System.currentTimeMillis() - start + "ms");
		System.out.println(count);
	}
}
