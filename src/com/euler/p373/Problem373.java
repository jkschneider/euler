package com.euler.p373;

import static java.lang.Math.floor;

import static java.lang.Math.max;

import static java.lang.Math.sqrt;

public class Problem373 {
	public static void main(String[] args) {
		int N = 100;
		int sum = 0;

		double rad = 0.0;
		for (int c = 1; c < N*2; c++) {
			for (int b = c; b < N*2; b++) { // b >= a to avoid duplicate
				int a;
				for (a = max(c, b); a < b + c; a++) { // c must satisfy triangle inequality
					rad = radius(a, b, c);
					if (rad > N)
						break;
					
					if (floor(rad) == rad && rad <= N) {
						System.out.print(c + ", " + b + ", " + a + " = ");
						System.out.println(rad);
						sum += rad;
					}
					else if(rad - floor(rad) < 0.0000001) {
						System.out.print("CLOSE: ");
						System.out.print(c + ", " + b + ", " + a + " = ");
						System.out.println(rad);
					}
				}
			}
		}

		System.out.println("sum = " + sum);
	}

	private static double radius(int a, int b, int c) {
		return (a * b * c) / sqrt((a + (b + c)) * (c - (a - b)) * (c + (a - b)) * (a + (b - c)));
	}
}
