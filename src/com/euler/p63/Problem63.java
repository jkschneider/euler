package com.euler.p63;

public class Problem63 {
	public static void main(String[] args) {
		int count = 0;
		for(int p = 0; p < 100; p++) {
			for(int n = 1; n <= 10000; n++) {
				Integer exp = (int) Math.pow(n,p);
				if(exp.toString().length() == p) {
					count++;
					System.out.println(n + "^" + p);
				}
			}
		}
		
		System.out.println("count = " + count);
	}
}
